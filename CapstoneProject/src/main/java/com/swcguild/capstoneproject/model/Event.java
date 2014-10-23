/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Event {
    private int eventId;
    private int userId;
    private String eventName;
    private LocalDate checkOutDate;
    private LocalDate dueDate;
    private List<Integer> assets;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public List<Integer> getAssets() {
        return assets;
    }

    public void setAssets(List<Integer> assets) {
        this.assets = assets;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.eventId;
        hash = 23 * hash + this.userId;
        hash = 23 * hash + Objects.hashCode(this.eventName);
        hash = 23 * hash + Objects.hashCode(this.checkOutDate);
        hash = 23 * hash + Objects.hashCode(this.dueDate);
        hash = 23 * hash + Objects.hashCode(this.assets);
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
        final Event other = (Event) obj;
        if (this.eventId != other.eventId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.eventName, other.eventName)) {
            return false;
        }
        if (!Objects.equals(this.checkOutDate, other.checkOutDate)) {
            return false;
        }
        if (!Objects.equals(this.dueDate, other.dueDate)) {
            return false;
        }
        if (!Objects.equals(this.assets, other.assets)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Event Id: ").append(eventId).append("\n");
        sb.append("Event Name: ").append(eventName).append("\n");
        sb.append("User Id: ").append(userId).append("\n");
        sb.append("Start Date: ").append(checkOutDate).append("\n");
        sb.append("Due Date: ").append(dueDate).append("\n");
        sb.append("Number of Assets: ").append(assets.size()).append("\n");
        return sb.toString();
    }
}
