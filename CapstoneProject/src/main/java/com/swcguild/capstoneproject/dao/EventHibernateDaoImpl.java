/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.dao;

import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.Event;
import com.swcguild.capstoneproject.model.notes.EventNote;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
@Transactional
public class EventHibernateDaoImpl implements EventInterface {

    private SessionFactory sessionFactory;
    private JdbcTemplate jdbcTemplate;

    @Inject
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Inject //setter injection
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
        List<Event> getEventsByUserIdList = currentSession()
                .createSQLQuery("select * from events where user_id = " + userId)
                .addEntity(Event.class).list();
        return new HashSet<>(getEventsByUserIdList);
    }

    @Override
    public Set<Event> getAllEvents() {
        List<Event> getAllEventsList = currentSession().createCriteria(Event.class).list();
        return new HashSet<>(getAllEventsList);
        
    }

    @Override
    public Set<Asset> getAllAssetsForEvent(Event event) {
        return event.getAssets();
    }

    @Override
    public void closeEvent(Event event) {
        event.setOpen(false);
    }



//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public void addNoteToEvent(String note, int eventId) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("insert into event_notes(event_id, note_detail) values");
//        sb.append("(").append(eventId).append(",").append(note).append(")");
//        currentSession().createSQLQuery(sb.toString());
//    }
//    
//    @Override
//    public List<String> getEventNote(int eventId) {
//        return (List<String>) currentSession()
//                .createSQLQuery("select * from event_notes where event_id =  " + eventId)
//                .addEntity(String.class).list();
//    }

    @Override
    public void addNoteToEvent(String note, int eventId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EventNote> getEventNote(int eventId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
