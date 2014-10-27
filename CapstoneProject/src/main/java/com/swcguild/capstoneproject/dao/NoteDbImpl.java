/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.dao;

import com.swcguild.capstoneproject.dao.interfaces.NoteInterface;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

/**
 *
 * @author apprentice
 */
public class NoteDbImpl implements NoteInterface {

    private SessionFactory sessionFactory;

    @Inject //constructor injection
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void addNoteToAsset(int assetId, String note, String category) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into asset_notes(asset_id, note_detail, note_category) values");
        sb.append("(").append(assetId).append(",").append(note).append(",").append(category).append(")");
        currentSession().createSQLQuery(sb.toString());
    }

    @Override
    public void addNoteToEvent(String note, int eventId) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into event_notes(event_id, note_detail) values");
        sb.append("(").append(eventId).append(",").append(note).append(")");
        currentSession().createSQLQuery(sb.toString());
    }

    @Override
    public void addNoteToUser(String note, int userId) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into user_notes(user_id, note_detail) values");
        sb.append("(").append(userId).append(",").append(note).append(")");
        currentSession().createSQLQuery(sb.toString());
    }
}
