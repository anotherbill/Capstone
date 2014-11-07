/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.controller;

import com.swcguild.capstoneproject.dao.interfaces.AssetInterface;
import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.dao.interfaces.UserInterface;
import com.swcguild.capstoneproject.model.AssetType;
import com.swcguild.capstoneproject.model.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping("/rest")
public class RestController {
    //Rachel's playing around with ajax
    
      private EventInterface eventDao;
    private UserInterface userDao;
    private AssetInterface assetDao;

    @Inject
    public void setEventDao(EventInterface eventDao) {
        this.eventDao = eventDao;
    }

    @Inject
    public void setUserDao(UserInterface userDao) {
        this.userDao = userDao;
    }

    @Inject
    public void setAssetDao(AssetInterface assetDao) {
        this.assetDao = assetDao;
    }

    
    @RequestMapping(value="/assetTypes", method=RequestMethod.GET)
    @ResponseBody public Set<AssetType> getAssetTypes() {
        return assetDao.getAllAssetTypes();
    }
    
    @RequestMapping(value="/assetType/{assetTypeId}", method=RequestMethod.GET)
    @ResponseBody public AssetType getAssetType(@PathVariable("assetTypeId") int id) {
        return assetDao.getAssetTypeById(id);
    }
    
    @RequestMapping(value="/assetType{assetTypeId}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody public void closeEvent(@PathVariable("assetTypeId") int id) {
        Event e = eventDao.getEventByEventId(id);
        eventDao.closeEvent(e);
    }
    
    public AssetType createAssetType(AssetType assetType) {
        //rest template like jdbctemplates. hide details we need for ajax calls
        RestTemplate rt = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJacksonHttpMessageConverter());
        //the thing that helps us from java to json for us
        rt.setMessageConverters(converters);
        return rt.postForObject("http://localhost:8080/CapstoneProject/rest/assetTypes", assetType, AssetType.class);
    }
    
    @RequestMapping(value="/assetType", method=RequestMethod.GET)
    public String assetType() {
        return "assetType";
    }
    

}
