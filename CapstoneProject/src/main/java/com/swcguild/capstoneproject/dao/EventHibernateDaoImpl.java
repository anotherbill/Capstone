/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.dao;

import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.Event;
import java.util.Set;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
@Transactional
public class EventHibernateDaoImpl implements EventInterface {

    private SessionFactory sessionFactory;

    @Inject //constructor injection
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    @Override
    public void addEvent(Event event) {
        currentSession().save(event);
    }

    @Override
    public void editEvent(Event event) {
        currentSession().update(event);
    }

    @Override
    public void deleteEvent(Event event) {
        currentSession().delete(event);
    }

    @Override
    public Event getEventByEventId(int eventId) {
        return (Event) currentSession().get(Event.class, eventId);
    }

    @Override
    public Set<Event> getEventsByUserId(int userId) {
        return (Set<Event>) currentSession()
                .createSQLQuery("select * from events where user_id = " + userId)
                .addEntity(Event.class).list();
    }

    @Override
    public Set<Event> getAllEvents() {
        return (Set<Event>) currentSession().createCriteria(Event.class);
    }

    @Override
    public Set<Asset> getAllAssetsForEvent(Event event) {
        return event.getAssets();
    }

    @Override
    public void closeEvent(Event event) {
        event.setOpen(false);
    }
    
}
