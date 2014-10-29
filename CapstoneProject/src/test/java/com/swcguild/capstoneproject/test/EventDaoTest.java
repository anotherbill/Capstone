/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.test;

import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.model.Event;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
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
    public void setUp() throws SQLException, FileNotFoundException {
        // Ask Spring for Dao
        ApplicationContext ctx
            = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (EventInterface) ctx.getBean("eventDao");
        
        jdbcT = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        ScriptRunner scrRun = new ScriptRunner(jdbcT.getDataSource().getConnection());
        scrRun.runScript(new FileReader("quartermaster_test_data_script.sql"));
        
        
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
        Event e = new Event();
        int eventId = 5;
        
        e = dao.getEventByEventId(eventId);
        assertEquals(dao.getEventByEventId(eventId).getEventName(), e.getEventName());
    }
}
