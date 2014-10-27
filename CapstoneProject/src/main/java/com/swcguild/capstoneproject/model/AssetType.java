/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    private Category category;
    
    @Column(name="image_path")
    private String imagePath;
    
    @OneToMany(mappedBy="assetType", fetch = FetchType.EAGER)
    private Set<Asset> assets;

    public int getAssetTypeId() {
        return assetTypeId;
    }

    public void setAssetTypeId(int assetTypeId) {
        this.assetTypeId = assetTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Set<Asset> getAssets() {
        return assets;
    }

    public void setAssets(Set<Asset> assets) {
        this.assets = assets;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.assetTypeId;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.category);
        hash = 29 * hash + Objects.hashCode(this.imagePath);
        hash = 29 * hash + Objects.hashCode(this.assets);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AssetType other = (AssetType) obj;
        if (this.assetTypeId != other.assetTypeId) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.imagePath, other.imagePath)) {
            return false;
        }
        if (!Objects.equals(this.assets, other.assets)) {
            return false;
        }
        return true;
    }

    
}
