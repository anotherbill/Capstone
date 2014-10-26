/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author apprentice
 */
@Entity
@Table(name="asset_types")
public class AssetType {
    @Id
    @GeneratedValue
    @Column(name="asset_type_id")
    private int assetTypeId;
    
    @Column(name="name")
    private String name;
    
    @OneToOne(mappedBy = "category")  //I think this is right
    private String category;
    
    @Column(name="image_path")
    private String imagePath;
    
    @ManyToOne
    @JoinColumn(name="asset_type_id") //also think this is right, but need to check
    private List<Asset> assets;
    

    
    
    
}
