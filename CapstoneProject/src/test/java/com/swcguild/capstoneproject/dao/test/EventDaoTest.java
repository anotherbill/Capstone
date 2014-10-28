/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.dao.test;

import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.model.Event;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class EventDaoTest {

    EventInterface dao;
    Event e1;
    Event e2;
    Event e3;

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
        // Ask Spring for Dao
        ApplicationContext ctx
            = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (EventInterface) ctx.getBean("eventDao");
        
        
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
    public void crudEventTest() {
        //System.out.println(dao.getEventByEventId(5).getEventName());
        assertEquals(dao.getEventByEventId(5).getEventName(), "Girl scouts camping trip");
        
    }
}
