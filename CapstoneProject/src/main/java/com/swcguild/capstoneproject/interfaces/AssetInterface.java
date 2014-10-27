/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.interfaces;

import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.AssetType;
import com.swcguild.capstoneproject.model.Category;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface AssetInterface {
    //This interface contains all the methods necessary for managing the inventory
    //This includes CRUD on Assets, AssetTypes, and Categories
    
    //Assets
    public void addAsset(Asset asset);
    
    public void editAsset(Asset asset);
    
    public void deleteAsset(Asset asset);
    
    public Asset getAssetById(int assetId);
    
    public List<Asset> getAllAssets();
    
    //some basic filtering methods
    public List<Asset> getAllAvailableAssets();
    
    public List<Asset> getAllAssetsByAssetType(AssetType assetType);
    
    public List<Asset> getAllAvailableAssetsByAssetType(AssetType assetType);
    
    public void changeAssetDamageStatus(Asset asset, String damageStatus);
    
    
    //Asset Types
    public void addAssetType(AssetType assetType);
    
    public void editAssetType(AssetType assetType);
    
    public void deleteAssetType(AssetType assetType);
    
    public AssetType getAssetTypeById(int assetTypeId);
    
    public List<AssetType> getAssetTypeByCategory(Category category);

    
    //public List<AssetType> getAssetTypesByCategory(String category);
    
    //Categories
    public void addCategory(Category category);
    
    public void editCategory(Category category);
    
    public void deleteCategory(Category category);
    
    public List<Category> getAllCategories();  
}
