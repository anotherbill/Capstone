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
import com.swcguild.capstoneproject.model.notes.EventNote;
import java.util.List;
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
public class EventController {

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

    @RequestMapping(value = "addEventStepTwo", method = RequestMethod.GET)
    public String createEventStepTwo(Model model, @RequestParam("eventId") int eventId) {
        return "addEventStepTwo?eventId=" + eventId;
    }

    @RequestMapping(value = "/closeEvent", method = RequestMethod.GET)
    public String closeEvent(Model model, @RequestParam("eventId") int eventId) {
        Event eventToClose = eventDao.getEventByEventId(eventId);
        eventDao.closeEvent(eventToClose);
        return "redirect:index";
    }

    @RequestMapping(value = "/openEvent", method = RequestMethod.GET)
    public String openEvent(Model model, @RequestParam("eventId") int eventId) {
        Event eventToOpen = eventDao.getEventByEventId(eventId);
        eventDao.openEvent(eventToOpen);
        return "redirect:index";
    }

    @RequestMapping(value = "/editEvent", method = RequestMethod.GET)
    public String showEditEventPage(Model model, @RequestParam("eventId") int eventId){
       Event eventToEdit = eventDao.getEventByEventId(eventId);

        eventDao.addEvent(eventToEdit);
        model.addAttribute("event", eventToEdit);

        Set<Asset> assetsCheckedOutForEvent = eventDao.getAllAssetsForEvent(eventToEdit);
        model.addAttribute("assetCheckedOutList", assetsCheckedOutForEvent);

        Set<Category> categoryList = assetDao.getAllCategories();
        model.addAttribute("categoryList", categoryList);

        Set<AssetType> assetTypeList = assetDao.getAllAssetTypes();
        model.addAttribute("assetTypeList", assetTypeList);
        
        return "editEvent";
    }
    
    @RequestMapping(value = "/viewEventInfo", method=RequestMethod.GET)
    public String showEventInfo(Model model, @RequestParam("eventId") int eventId){
        Event event = eventDao.getEventByEventId(eventId);
        model.addAttribute("event", event);
        return "viewEventInfo";
    }
            
    @RequestMapping(value ="/eventAddNote", method=RequestMethod.GET)
    public String showEventNotes(Model model, @RequestParam("eventId")int eventId){
        Event event = eventDao.getEventByEventId(eventId);
        model.addAttribute("event", event);
        
        EventNote eventNote = new EventNote();
        eventNote.setEventId(eventId);
        model.addAttribute("eventNote", eventNote);
        
        List<EventNote> eventNotes = eventDao.getEventNote(eventId);
        model.addAttribute("eventNoteList", eventNotes);

        return "eventAddNote";
    }
    
    @RequestMapping(value="/submitNewEventNote", method = RequestMethod.POST)
    public String addEventNoteToDatabase(Model model, @ModelAttribute("eventNote") EventNote eventNote){
        eventDao.addNoteToEvent(eventNote.getNote(), eventNote.getEventId());
        return "redirect:eventAddNote?eventId=" + eventNote.getEventId();
    }
}
