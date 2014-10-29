/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.test;

import com.swcguild.capstoneproject.dao.interfaces.UserInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.Event;
import com.swcguild.capstoneproject.model.User;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
public class UserInterfaceTest {

    UserInterface userDao;
    JdbcTemplate jdbcT;
    Set<Event> events;
    User u1;
    User u2;

    public UserInterfaceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException, FileNotFoundException{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        userDao = ctx.getBean("userDao", UserInterface.class);
        
        jdbcT = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        jdbcT.execute("delete from assets_events");
        jdbcT.execute("delete from events");
        jdbcT.execute("delete from users");
        
        //events = new HashSet<>();
        //events.add(new Event());
        
        u1 = new User();
        //u1.setUserId(3);
        u1.setUserName("bill");
        u1.setPassword("");
        u1.setEnabled(1);
        u1.setGoodStanding(true);
        u1.setName("1");
        //u1.setEvents(events);
        
        u2 = new User();
        u2.setUserName("testMan1");
        u2.setPassword("thePass0rd");
        u2.setGoodStanding(true);
        u2.setEnabled(1);
        u2.setName("John Doe");
        //u2.setEvents(new HashSet());

    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetUserTest() {
        User fromStorage;
        userDao.addUser(u2);
        
        fromStorage = userDao.getUserByUserId(u2.getUserId());
        assertEquals(u2, fromStorage);
    }
}
