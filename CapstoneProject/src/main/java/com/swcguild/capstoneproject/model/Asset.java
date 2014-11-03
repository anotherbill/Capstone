/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 *
 * @author apprentice
 */
@Entity
@Table(name="assets")
public class Asset {
    @Id
    @GeneratedValue
    @Column(name="asset_id")
    private int assetId;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="asset_type_id")
    private AssetType assetType; //using Hibernate we can have the entire type
    
    @Column(name="in_stock")
    private boolean inStock;
    
    @Column(name="serial_number")
    //@Size(min = 2, max =11, message="The serial number must be between 2 and 11 characters")
    @Digits(integer = 20, fraction = 0, message="The serial number must be a whole number no longer than 20 digits")
    private int serialNumber;
    
    @Column(name="damage_loss_theft")
    @Size(min = 1, max =20, message="The damage must be between 1 and 20 characters")
    private String damageStatus; 

    //@OneToMany(fetch = FetchType.EAGER, Cascade = Cascade.ALL)
    //@JoinColumn(asset_id)
    //private Set<AssetNote> assetNotes;
    
    
    //Getters and setters
    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDamageStatus() {
        return damageStatus;
    }

    public void setDamageStatus(String damageStatus) {
        this.damageStatus = damageStatus;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.assetId;
        hash = 67 * hash + (this.inStock ? 1 : 0);
        hash = 67 * hash + this.serialNumber;
        hash = 67 * hash + Objects.hashCode(this.damageStatus);
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
        final Asset other = (Asset) obj;
        if (this.assetId != other.assetId) {
            return false;
        }
        if (this.inStock != other.inStock) {
            return false;
        }
        if (this.serialNumber != other.serialNumber) {
            return false;
        }
        if (!Objects.equals(this.damageStatus, other.damageStatus)) {
            return false;
        }
        return true;
    }

    

    
    
    
}
