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
        Event tempEvent;
        userDao = ctx.getBean("userDao", UserInterface.class);
        jdbcT = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

        ScriptRunner scrRun = new ScriptRunner(jdbcT.getDataSource().getConnection());
        scrRun.runScript(new FileReader("quartermaster_test_data_script.sql"));

        //jdbcT.execute("delete from users");
        
        tempEvent = new Event();
        tempEvent.setEventId(1);
        /*
        tempEvent.setUser(u1);
        tempEvent.setEventName("Boy Scout Summer Campout");
        tempEvent.setCheckOutDate(new Date(2014, 10, 25));//why is every intuitive means of entering the date deprecated???
        tempEvent.setDueDate(new Date(2014, 10, 25));//who honestly knows the number of milliseconds since January 1, 1970, 00:00:00???
        tempEvent.setOpen(true);
        */
        events = new HashSet<>();
        events.add(tempEvent);
        
        u1 = new User();
        u1.setUserId(3);
        u1.setUserName("bill");
        u1.setPassword("");
        u1.setEnabled(1);
        u1.setGoodStanding(true);
        u1.setName("1");
        u1.setEvents(events);
        //tempEvent.setUser(u1);
        
        u2 = new User();
        u2.setUserName("testMan1");
        u2.setPassword("thePass0rd");
        u2.setGoodStanding(true);
        u2.setEnabled(1);
        u2.setName("John Doe");
        u2.setEvents(new HashSet());

    }

    @After
    public void tearDown() {
    }

    @Test
    public void getUserTest() {
        User fromStorage;
        fromStorage = userDao.getUserByUserId(u1.getUserId());

        /*
            equals method in User dependent on
            specific implementation of Set interface for events field
            (see line 144). Unusable in tests. Consider revising.
        */
        assertEquals(u1, fromStorage);
        /*
        assertEquals(u1.getUserId(), fromStorage.getUserId());
        assertEquals(u1.getPassword(), fromStorage.getPassword());
        assertEquals(u1.getEnabled(), fromStorage.getEnabled());
        assertEquals(u1.getName(), fromStorage.getName());
        assertEquals(u1.getUserName(), fromStorage.getUserName());
        //assertTrue(fromStorage.getEvents().containsAll(u1.getEvents()));
        assertEquals(u1.getEvents().size(),fromStorage.getEvents().size());
                */
    }
    
    
    @Test
    public void addGetUserTest() {
        User fromStorage;
        userDao.addUser(u2);
        
        fromStorage = userDao.getUserByUserId(u2.getUserId());
        
        assertTrue(usersEqual(u2, fromStorage));
    }
    
    private boolean usersEqual(User expected, User actual){
        return expected.getUserId() == actual.getUserId()
                && expected.getUserName().equals(actual.getUserName())
                && expected.getEnabled() == actual.getEnabled()
                && expected.getName().equals(actual.getName())
                && expected.getPassword().equals(actual.getPassword())
                && expected.getEvents().size() == actual.getEvents().size();
                
    }

}
