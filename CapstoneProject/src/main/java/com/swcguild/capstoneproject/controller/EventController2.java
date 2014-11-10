/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.controller;

import com.swcguild.capstoneproject.dao.interfaces.AssetInterface;
import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.dao.interfaces.UserInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.AssetType;
import com.swcguild.capstoneproject.model.Category;
import com.swcguild.capstoneproject.model.Event;
import com.swcguild.capstoneproject.model.User;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author apprentice
 */
@Controller
public class EventController2 {
    private static final String BAD_ASSET_TYPE_ERROR_MESSAGE = "Oops! Invalid asset type ID. Must supply asset type ID as an integer. Asset type ID must refer to an existing asset type.";
    private static final String BAD_EVENT_ERROR_MESSAGE = "Oops! Invalid event ID. Must supply event ID as an integer. Event ID must refer to an existing Event.";
    private static final String NO_SUCH_ASSET_AVAILABLE_PART1 = "I'm sorry, but we currently do not have any ";
    private static final String NO_SUCH_ASSET_AVAILABLE_PART2 = " available.";
    
    
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
    
     @RequestMapping(value = "/addEvent", method = RequestMethod.GET)
    public String addEventStepOne(Model model) {
        Event event = new Event();
        model.addAttribute("event", event);

        Set<User> userList = userDao.getAllUsers();
        model.addAttribute("userList", userList);

        return "addEventStepOne";
    }

    @RequestMapping(value = "/submitAddEventStepOne", method = RequestMethod.POST)
    public String createEventStepOne(Model model, @ModelAttribute("event") Event event, HttpServletRequest req) {
        int userId = Integer.parseInt(req.getParameter("userName"));
        User eventUser = userDao.getUserByUserId(userId);

        event.setUser(eventUser);
        event.setOpen(true);

        eventDao.addEvent(event);
        model.addAttribute("event", event);

        Set<Asset> assetsCheckedOutForEvent = eventDao.getAllAssetsForEvent(event);
        model.addAttribute("assetCheckedOutList", assetsCheckedOutForEvent);

        Set<Category> categoryList = assetDao.getAllCategories();
        model.addAttribute("categoryList", categoryList);

        Set<AssetType> assetTypeList = assetDao.getAllAssetTypes();
        model.addAttribute("assetTypeList", assetTypeList);

        return "addEventStepTwo";
    }
    
    @RequestMapping(value = "addEventAsset", method = RequestMethod.GET)
    public String addEventAsset(Model model, HttpServletRequest request){
        int typeId;
        int eventId;
        Event event;
        AssetType assetType;
        Asset asset;
        boolean nullVal;
        Set<Asset> eventAssets = new HashSet<>();
        
        //attempt to retrieve Event by Id
        try{
            eventId = Integer.parseInt(request.getParameter("eventId"));
        } catch(NumberFormatException e){
            eventId = 0;
        }
        
        event = eventDao.getEventByEventId(eventId);
        
        //resolve invalid eventId
        nullVal = event == null;
        if (nullVal) {
            if (nullVal) {
                model.addAttribute("badEventError", BAD_EVENT_ERROR_MESSAGE);
            }
            return "addEventStepTwo";
        }
        
        //supply model attributes
        model.addAttribute("event", event);

        Set<Asset> assetsCheckedOutForEvent = eventDao.getAllAssetsForEvent(event);
        model.addAttribute("assetCheckedOutList", assetsCheckedOutForEvent);

        Set<Category> categoryList = assetDao.getAllCategories();
        model.addAttribute("categoryList", categoryList);

        Set<AssetType> assetTypeList = assetDao.getAllAssetTypes();
        model.addAttribute("assetTypeList", assetTypeList);

        
        //attempt to retrieve AssetType by Id
        try {
            typeId = Integer.parseInt(request.getParameter("typeId"));
        } catch (NumberFormatException e) {
            typeId = 0;
        }

        assetType = assetDao.getAssetTypeById(typeId);
        
        //resolve invalid assetTypeId
        nullVal = assetType == null;
        if (nullVal) {
            if (nullVal) {
                model.addAttribute("badAssetTypeError", BAD_ASSET_TYPE_ERROR_MESSAGE);
            }
            return "addEventStepTwo";
        }
        
        //attempt to retrieve available asset by assetType
        asset = assetDao.getAnyAvailableAssetByAssetType(assetType);
        //resolve unavailable asset
        nullVal = asset == null;
        if (nullVal) {
            if (nullVal) {
                model.addAttribute("unavailableAssetError", NO_SUCH_ASSET_AVAILABLE_PART1 + assetType.getName() + NO_SUCH_ASSET_AVAILABLE_PART2);
            }
            return "addEventStepTwo";
        }
        asset.setInStock(false);
        assetDao.editAsset(asset);
        
        //retrieve assets associated with event
        eventAssets = event.getAssets();
        if(eventAssets == null){
            eventAssets = new HashSet<>();
        }
        
        //assign new asset to event
        eventAssets.add(asset);
        event.setAssets(eventAssets);
        eventDao.editEvent(event);
        
        return "addEventStepTwo";
    }
}
