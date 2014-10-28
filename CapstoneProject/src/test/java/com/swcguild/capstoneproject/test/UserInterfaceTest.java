/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.test;

import com.swcguild.capstoneproject.dao.interfaces.UserInterface;
import com.swcguild.capstoneproject.model.User;
import java.sql.SQLException;
import java.util.HashSet;
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
public class UserInterfaceTest {

    UserInterface userDao;
    JdbcTemplate jdbcT;

    User u1;

    public UserInterfaceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        userDao = ctx.getBean("userDao", UserInterface.class);
        jdbcT = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

        try {
            ScriptRunner scrRun = new ScriptRunner(jdbcT.getDataSource().getConnection());
            
        } catch (SQLException e) {

        }
        //jdbcT.execute("delete from users");

        u1 = new User();
        u1.setUserName("theFirst");
        u1.setPassword("abc");
        u1.setEnabled(1);
        u1.setGoodStanding(true);
        u1.setName("John Doe");
        u1.setEvents(new HashSet());

    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetUserTest() {
        User fromStorage;
        userDao.addUser(u1);
        fromStorage = userDao.getUserByUserId(u1.getUserId());

        assertEquals(u1, fromStorage);

    }

}
