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
import javax.persistence.OneToMany;
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
    
    @ManyToOne
    @JoinColumn(name="category_id")//I think this is right
    private String category;
    
    @Column(name="image_path")
    private String imagePath;
    
    @OneToMany(mappedBy="asset")
    private List<Asset> assets;
    

    
    
    
}
