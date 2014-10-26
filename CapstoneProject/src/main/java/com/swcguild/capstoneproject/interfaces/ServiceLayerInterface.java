/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.interfaces;

/**
 *
 * @author apprentice
 */
public interface ServiceLayerInterface {

    //Contains all the methods that require multiple operations and span multiple tables.
    //Most of these relate to the create new event and check-in/check-out assets business functions
   
    public int checkOutAsset(int assetTypeId, int eventId);
    //For a particular event, check out a specific instance of the assetType and then return the assetId
    //This will need some more fleshing out...
    
    public boolean checkInAsset(int assetId, int eventId);
    //takes an asset Id and then returns whether the Item has been succesfully checked in or not, eg asset.isInStock();
    
    public void retireAsset(int assetId);

    public void addAssetToEvent(int eventId);

    //Note methods
    public void addNoteToAsset(String note, int assetId);

    public void addNoteToEvent(String note, int eventId);

    public void addNoteToUser(String note, int userId);

}
