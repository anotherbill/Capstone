/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.dao;

import com.swcguild.capstoneproject.dao.interfaces.AssetCheckInServiceInterface;
import com.swcguild.capstoneproject.dao.interfaces.AssetInterface;
import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.notes.EventNote;
import java.util.Date;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
@Repository
public class AssetCheckInService implements AssetCheckInServiceInterface {
    private static final String SQL_CHECK_IN_ASSET = "update assets_events set return_date = ? where event_id = ? and asset_id = ?;";
    private static final String SQL_SELECT_RETURN_DATE = "select return_date from assets_events where event_id = ? and asset_id = ?;";
    
    private JdbcTemplate jdbcTemplate;
    private AssetInterface assetDao;

    @Inject
    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Inject
    @Override
    public void setAssetDao(AssetInterface assetDao) {
        this.assetDao = assetDao;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public Date checkInAsset(int eventId, int assetId){
        Asset asset;
        Date today = new Date();
        Date existingDate = getReturnDate(eventId, assetId);
        
        if(existingDate == null){
        jdbcTemplate.update(SQL_CHECK_IN_ASSET, today, eventId, assetId);
        asset = assetDao.getAssetById(assetId);
        asset.setInStock(true);
        assetDao.editAsset(asset);
        return today;    
        }
        else{
            return existingDate;
        }
        
    }
    
    @Override
    public Date getReturnDate(int eventId, int assetId){
        return jdbcTemplate.queryForObject(SQL_SELECT_RETURN_DATE, Date.class, eventId, assetId);
    }
}
