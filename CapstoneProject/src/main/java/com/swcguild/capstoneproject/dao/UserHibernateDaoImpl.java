/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.dao;

import com.swcguild.capstoneproject.interfaces.UserInterface;
import com.swcguild.capstoneproject.model.User;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class UserHibernateDaoImpl implements UserInterface{

     private SessionFactory sessionFactory;

    @Inject //constructor injection
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addUser(User user) {
        currentSession().save(user);
    }

    @Override
    public void editUser(User user) {
        currentSession().update(user);
    }

    @Override
    public void deleteUser(User user) {
        currentSession().delete(user);
    }

    @Override
    public User getUserByUserId(int userId) {
        return (User) currentSession().get(User.class, userId);
    }

    @Override
    public void resetPassword(User user) {
        //I have no idea how to do this yet
    }

    @Override
    public void changeUserPassword(User user, String password) { //This probably has some kind of database hashing security along with it
        user.setPassword(password);
        currentSession().update(user);
    }
    
}
