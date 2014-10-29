/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.test;

import com.swcguild.capstoneproject.dao.interfaces.AssetInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.AssetType;
import com.swcguild.capstoneproject.model.Category;
import org.junit.After;
import org.junit.AfterClass;
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
public class AssetDaoTest {
    AssetInterface dao;
    JdbcTemplate jdbcTemplate;
    
    Category Tents;
    AssetType t1;
    Asset a;
    
    public AssetDaoTest() {
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
        dao = (AssetInterface) ctx.getBean("assetDao");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        
        Tents = new Category();
        Tents.setCategoryId(1);
        Tents.setCategoryName("Tents");
        
        t1 = new AssetType();
        t1.setAssetTypeId(1);
        t1.setName("Tent");
        t1.setCategory(Tents);
        t1.setImagePath("tentImage.jpg");
        
        
        a = new Asset();
        a.setAssetId(1);
        a.setAssetType(t1);
        a.setSerialNumber(111);
        a.setInStock(true);
        a.setDamageStatus("");
        
             
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void addGetRemoveAsset(){
        
    }
    
}
