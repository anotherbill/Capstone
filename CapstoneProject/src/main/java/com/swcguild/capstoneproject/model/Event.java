/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author apprentice
 */
@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue
    @Column(name="event_id")
    private int eventId;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user; //get everything about the user through Hibernate
    
    @Column(name="event_name")
    private String eventName;
    
    @Column(name="check_out_date")
    private LocalDate checkOutDate;
    
    @Column(name="due_date")
    private LocalDate dueDate;
    
    @ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
    @JoinTable(name="assets_events", joinColumns ={@JoinColumn(name="event_id")}, inverseJoinColumns={@JoinColumn(name="asset_id")})
    private List<Asset> assets; //we can do this through Hibernate
    
    @Column(name="open")
    boolean open;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.eventId;
        hash = 37 * hash + Objects.hashCode(this.user);
        hash = 37 * hash + Objects.hashCode(this.eventName);
        hash = 37 * hash + Objects.hashCode(this.checkOutDate);
        hash = 37 * hash + Objects.hashCode(this.dueDate);
        hash = 37 * hash + Objects.hashCode(this.assets);
        hash = 37 * hash + (this.open ? 1 : 0);
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
        if (!Objects.equals(this.user, other.user)) {
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
        if (this.open != other.open) {
            return false;
        }
        return true;
    }

   

    
}
