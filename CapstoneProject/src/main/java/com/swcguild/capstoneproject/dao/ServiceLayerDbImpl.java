/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.dao;

import com.swcguild.capstoneproject.dao.interfaces.AssetInterface;
import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.dao.interfaces.ServiceLayerInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.AssetType;
import com.swcguild.capstoneproject.model.Event;
import java.time.LocalDate;
import java.util.Date;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class ServiceLayerDbImpl implements ServiceLayerInterface {
    
    private SessionFactory sessionFactory;

    @Inject //constructor injection
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    AssetInterface assetInterfaceImpl;
    EventInterface eventInterfaceImpl;

    @Inject //setter injection
    public void setAssetInterfaceImpl(AssetInterface assetInterfaceImpl) {
        this.assetInterfaceImpl = assetInterfaceImpl;
    }

    @Inject //setter injection
    public void setEventInterfaceImpl(EventInterface eventInterfaceImpl) {
        this.eventInterfaceImpl = eventInterfaceImpl;
    }
   
    //Method implementations

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly= false) //this should all work, or none of it should
    public void addAssetToEvent(int assetTypeId, int eventId) {
        //get an available asset of a particular AssetType
        //set it to checked out
        //write it to the assets_events table
        
        //Get the event
        Event currentEvent = eventInterfaceImpl.getEventByEventId(eventId);
        
        //Get an available asset based on an asset type
        AssetType assetTypeToGet = assetInterfaceImpl.getAssetTypeById(assetTypeId);
        Asset assetToCheckOut = assetInterfaceImpl.getAnyAvailableAssetByAssetType(assetTypeToGet);
        assetToCheckOut.setInStock(false);
        
        //Add asset to Event
        currentEvent.getAssets().add(assetToCheckOut);

    }

    @Override
    public void checkInAsset(int assetId, int eventId) {
        Asset assetToCheckIn = assetInterfaceImpl.getAssetById(assetId);
        assetToCheckIn.setInStock(true);
        //set in_stock to true for a particular item for a particular event
        //set return date for that item to LocalDate.now()
        StringBuilder sb = new StringBuilder();
        sb.append("insert into assets_events (asset_id, event_id, return_date) values");
        sb.append("(").append(assetId).append(",").append(eventId).append(",").append(new Date().toString()).append(")");
        
        //run the query
        currentSession().createSQLQuery(sb.toString());
    
//        jdbcTemplate.update(SQL_WRITE_ASSET_RETURN_DATE,
//                assetId,
//                eventId,
//                LocalDate.now().toString());

    }

    @Override
    public void retireAsset(Asset asset) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
    
    //PREPARED STATEMENTS
    private static final String SQL_WRITE_ASSET_RETURN_DATE = "insert into assets_events (asset_id, event_id, return_date) values (?, ?, ?) ";
    private static final String SQL_WRITE_USER_NOTE = "";
    private static final String SQL_WRITE_ASSET_NOTE = "";
    private static final String SQL_WRITE_EVENT_NOTE = "";
    
    
}
