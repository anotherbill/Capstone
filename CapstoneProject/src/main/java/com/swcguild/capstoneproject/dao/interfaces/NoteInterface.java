/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.dao.interfaces;

import java.util.List;

/**
 *
 * @author apprentice
 */
public interface NoteInterface {
    
    //Note methods
    public void addNoteToAsset(int assetId, String note, String category);

    public void addNoteToEvent(String note, int eventId);

    public void addNoteToUser(String note, int userId);
    
    public List<String> getEventNote(int eventId);
    
    public List<String> getUserNotes(int userId);
    
    public List<String> getAssetNotes(int assetId);
    
}
