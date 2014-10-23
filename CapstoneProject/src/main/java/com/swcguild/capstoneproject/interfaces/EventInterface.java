/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.interfaces;

import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.Event;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface EventInterface {
    
    public void addEvent(Event event);
    
    public void editEvent(Event event);
    
    public void deleteEvent(int eventId);
    
    public Event getEventByEventId(int eventId);
    
    List<Asset> getAllAssetsByEventId(int eventId);
    
    public void addAssetToEvent(int eventId);
    
    public void addNoteToEvent(String note, int eventId);
    
    public List<Event> getEventsByUserId(int userId);
    
    
    
    
    
    
    
    
}
