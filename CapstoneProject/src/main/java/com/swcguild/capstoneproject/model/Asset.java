/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.model;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Asset {
    private int assetId;
    AssetType assetType; //using Hibernate we can have the entire type
    private boolean inStock;
    private int serialNumber;
    private String damageStatus; 

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
        hash = 41 * hash + this.assetId;
        hash = 41 * hash + Objects.hashCode(this.assetType);
        hash = 41 * hash + (this.inStock ? 1 : 0);
        hash = 41 * hash + this.serialNumber;
        hash = 41 * hash + Objects.hashCode(this.damageStatus);
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
        if (!Objects.equals(this.assetType, other.assetType)) {
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
