/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.dao;

import com.swcguild.capstoneproject.dao.interfaces.AssetInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.AssetType;
import com.swcguild.capstoneproject.model.Category;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
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
        return (Asset) currentSession().get(Asset.class, assetId);
    }

    @Override
    public Asset getAnyAvailableAssetByAssetType(AssetType assetType) {
        return (Asset) currentSession()
                .createSQLQuery("select * from assets where in_stock = 1 and asset_type_id = " + assetType.getAssetTypeId() + " order by asset_id LIMIT 1")
                .addEntity(Asset.class);
    }

    @Override
    public Set<Asset> getAllAssets() {
        List<Asset> getAllAssetsList =  currentSession().createCriteria(Asset.class).list();
        return new HashSet<>(getAllAssetsList);
    }

    @Override
    public Set<Asset> getAllAvailableAssets() {
       List<Asset> getAllAvailableAssetsList = currentSession().createSQLQuery("select * from assets where in_stock = 1").addEntity(Asset.class).list();
       return new HashSet<>(getAllAvailableAssetsList);
    }

    @Override
    public Set<Asset> getAllAssetsByAssetType(AssetType assetType) {
       List<Asset> getAllAssetsByAssetTypeList = currentSession().createSQLQuery("select * from assets where asset_type_id = " + assetType.getAssetTypeId())
                .addEntity(Asset.class).list();
       return new HashSet<>(getAllAssetsByAssetTypeList);
    }

    @Override
    public Set<Asset> getAllAvailableAssetsByAssetType(AssetType assetType) {
        List<Asset> getAllAvailableAssetsByAssetTypeList = currentSession()
                .createSQLQuery("select * from assets where asset_type_id = " + assetType.getAssetTypeId() + " and in_stock = 1")
                .addEntity(Asset.class).list();
        return new HashSet<>(getAllAvailableAssetsByAssetTypeList);
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
    public Set<AssetType> getAssetTypeByCategory(Category category) {
        List<AssetType> assetTypeList = currentSession()
                .createSQLQuery("select * from asset_types where category_id =" + category.getCategoryId())
                .addEntity(AssetType.class).list();
       return  new HashSet(assetTypeList);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
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
    public Set<Category> getAllCategories() {
        List<Category> getAllCategoriesList = currentSession().createCriteria(Category.class).list();
        return new HashSet<>(getAllCategoriesList);
    }

}
