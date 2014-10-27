/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.dao;

import com.swcguild.capstoneproject.interfaces.AssetInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.AssetType;
import com.swcguild.capstoneproject.model.Category;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
@Repository
@Transactional
public class AssetHibernateDaoImpl implements AssetInterface {
    
    private SessionFactory sessionFactory;
    
    @Inject //constructor injection
    public void setSesstionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    private Session currentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addAsset(Asset asset) {
        currentSession().save(asset);
    }

    @Override
    public void editAsset(Asset asset) {
        currentSession().update(asset);
    }

    @Override
    public void deleteAsset(Asset asset) {
        currentSession().delete(asset);
    }

    @Override
    public Asset getAssetById(int assetId) {
        return(Asset) currentSession().get(Asset.class, assetId);
    }

    @Override
    public List<Asset> getAllAssets() {
        return (List<Asset>) currentSession().createCriteria(Asset.class).list();
    }

    @Override
    public List<Asset> getAllAvailableAssets() {
        return (List<Asset>) currentSession().createSQLQuery("select * from assets where in_stock = true").addEntity(Asset.class).list();
    }

    @Override
    public List<Asset> getAllAssetsByAssetType(AssetType assetType) {
        return (List<Asset>) currentSession().createSQLQuery("select * from assets where asset_type_id = " + assetType.getAssetTypeId())
                .addEntity(Asset.class).list();
    }

    @Override
    public List<Asset> getAllAvailableAssetsByAssetType(AssetType assetType) {
        return (List<Asset>) currentSession()
                .createSQLQuery("select * from assets where in_stock = true and asset_type_id = " + assetType.getAssetTypeId())
                .addEntity(Asset.class).list();
    }

    @Override
    public void changeAssetDamageStatus(Asset asset, String damageStatus) {
        asset.setDamageStatus(damageStatus);
        currentSession().update(asset);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addAssetType(AssetType assetType) {
        currentSession().save(assetType);
    }

    @Override
    public void editAssetType(AssetType assetType) {
        currentSession().update(assetType);
    }

    @Override
    public void deleteAssetType(AssetType assetType) {
        currentSession().delete(assetType);
    }

    @Override
    public AssetType getAssetTypeById(int assetTypeId) {
        return (AssetType) currentSession().get(AssetType.class, assetTypeId);
    }

    @Override
    public List<AssetType> getAssetTypeByCategory(Category category) {
        return (List<AssetType>) currentSession()
                .createSQLQuery("select * from asset_types where category_id =" + category.getCategoryId())
                .addEntity(AssetType.class).list();
    }

    @Override
   public void addCategory(Category category) {
       currentSession().save(category);
   }

    @Override
    public void editCategory(Category category) {
        currentSession().update(category);
    }

    @Override
    public void deleteCategory(Category category) {
        currentSession().delete(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) currentSession().createCriteria(Category.class).list();
    }
    
}
