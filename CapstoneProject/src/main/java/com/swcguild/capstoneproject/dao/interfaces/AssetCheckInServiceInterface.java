/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.dao.interfaces;

import com.swcguild.capstoneproject.dao.interfaces.AssetInterface;
import java.util.Date;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public interface AssetCheckInServiceInterface {

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    Date checkInAsset(int eventId, int assetId);

    Date getReturnDate(int eventId, int assetId);

    @Inject
    void setAssetDao(AssetInterface assetDao);

    @Inject
    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    
}
