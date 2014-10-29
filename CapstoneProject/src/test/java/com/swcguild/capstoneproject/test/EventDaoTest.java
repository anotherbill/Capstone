/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.capstoneproject.test;

import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.dao.interfaces.UserInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.AssetType;
import com.swcguild.capstoneproject.model.Category;
import com.swcguild.capstoneproject.model.Event;
import com.swcguild.capstoneproject.model.User;
import java.util.Date;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class EventDaoTest {
    
    JdbcTemplate jdbcT;
    EventInterface eventDao;
    UserInterface userDao;
    Event e1;
    Event e2;
    Event e3;
    User u1;
    User u2;
    Asset a1;
    Asset a2;
    Asset a3;
    Asset a4;
    Asset a5;
    AssetType at1;
    AssetType at2;
    AssetType at3;
    Category c1;
    Category c2;
    
    public EventDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx
            = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        eventDao = (EventInterface) ctx.getBean("eventDao");
        userDao = (UserInterface) ctx.getBean("userDao");
        jdbcT = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        
        jdbcT.execute("delete from assets_events");
        jdbcT.execute("delete from events");
        jdbcT.execute("delete from users");
        
        u1 = new User();
        u1.setGoodStanding(true);
        u1.setName("Name");
        u1.setPassword("password");
        u1.setUserName("userName");
        
        e1 = new Event();
        e1.setUser(u1);
        e1.setEventName("Party");
        Date date1out = new Date(1997,07,24);
        Date date1in = new Date(1997,07,26);
        e1.setCheckOutDate(date1out);
        e1.setDueDate(date1in);
        e1.setOpen(true);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void addGetDeleteUpdateEventTest() {
        //System.out.println(dao.getEventByEventId(5).getEventName());
        userDao.addUser(u1);
        eventDao.addEvent(e1);
        assertEquals(eventDao.getEventByEventId(e1.getEventId()).getEventName(), e1.getEventName());
        
        e1.setEventName("Hysteria");
        eventDao.editEvent(e1);
        assertEquals(eventDao.getEventByEventId(e1.getEventId()).getEventName(), e1.getEventName());
        
        eventDao.deleteEvent(e1);
        assertNull(eventDao.getEventByEventId(e1.getEventId()));
    }
    
//    @Test
//    public void getEventsByUserIdTest() {
//        userDao.addUser(u1);
//        eventDao.addEvent(e1);
//        assertEquals(eventDao.getEventsByUserId(u1.getUserId()).size(), 1);
//    }
    
}
