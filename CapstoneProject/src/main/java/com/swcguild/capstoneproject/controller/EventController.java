/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.controller;

import com.swcguild.capstoneproject.dao.AssetCheckInService;
import com.swcguild.capstoneproject.dao.interfaces.AssetCheckInServiceInterface;
import com.swcguild.capstoneproject.dao.interfaces.AssetInterface;
import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.dao.interfaces.UserInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.AssetType;
import com.swcguild.capstoneproject.model.Category;
import com.swcguild.capstoneproject.model.Event;
import com.swcguild.capstoneproject.model.User;
import com.swcguild.capstoneproject.model.notes.EventNote;
import java.util.ArrayList;
import java.util.Date;
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
    private AssetCheckInServiceInterface checkIn;

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

    @Inject
    public void setCheckIn(AssetCheckInServiceInterface checkIn) {
        this.checkIn = checkIn;
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
    public String showEditEventPage(Model model, @RequestParam("eventId") int eventId) {
        //List<Asset> assetList = new ArrayList<>();
        List<Date> returnDates = new ArrayList<>();
        Event eventToEdit = eventDao.getEventByEventId(eventId);
        model.addAttribute("event", eventToEdit);

        List<Asset> assetsCheckedOutForEvent = new ArrayList<>();
        assetsCheckedOutForEvent.addAll(eventDao.getAllAssetsForEvent(eventToEdit));
        //assetList.addAll(assetsCheckedOutForEvent);
        for(Asset a: assetsCheckedOutForEvent){
            returnDates.add(checkIn.getReturnDate(eventId, a.getAssetId()));//get return date for asset
        }

        model.addAttribute("assetCheckedOutList", assetsCheckedOutForEvent);
        model.addAttribute("returnDates", returnDates);
        
        Set<Category> categoryList = assetDao.getAllCategories();
        model.addAttribute("categoryList", categoryList);

        Set<AssetType> assetTypeList = assetDao.getAllAssetTypes();
        model.addAttribute("assetTypeList", assetTypeList);

        return "editEvent";
    }

    @RequestMapping(value = "/viewEventInfo", method = RequestMethod.GET)
    public String showEventInfo(Model model, @RequestParam("eventId") int eventId) {
        Event event = eventDao.getEventByEventId(eventId);
        model.addAttribute("event", event);
        return "viewEventInfo";
    }

    @RequestMapping(value = "/eventAddNote", method = RequestMethod.GET)
    public String showEventNotes(Model model, @RequestParam("eventId") int eventId) {
        Event event = eventDao.getEventByEventId(eventId);
        model.addAttribute("event", event);

        EventNote eventNote = new EventNote();
        eventNote.setEventId(eventId);
        model.addAttribute("eventNote", eventNote);

        List<EventNote> eventNotes = eventDao.getEventNote(eventId);
        model.addAttribute("eventNoteList", eventNotes);

        return "eventAddNote";
    }

    @RequestMapping(value = "/submitNewEventNote", method = RequestMethod.POST)
    public String addEventNoteToDatabase(Model model, @ModelAttribute("eventNote") EventNote eventNote) {
        eventDao.addNoteToEvent(eventNote.getNote(), eventNote.getEventId());
        return "redirect:eventAddNote?eventId=" + eventNote.getEventId();
    }

    @RequestMapping(value = "/submitEditEvent", method = RequestMethod.POST)
    public String editEventWriteToDatabase(Model model, @ModelAttribute("event") Event event, HttpServletRequest req) {
        boolean open = Boolean.parseBoolean(req.getParameter("open"));
        int userId = Integer.parseInt(req.getParameter("user.userId"));
        User eventUser = userDao.getUserByUserId(userId);
        event.setUser(eventUser);
        event.setOpen(open);
        eventDao.editEvent(event);
        return "redirect:viewEventInfo?eventId=" + event.getEventId();
    }

    @RequestMapping(value = "/checkInAsset", method = RequestMethod.GET)
    public String checkInAsset(Model model, HttpServletRequest req) {
        int eventId;
        int assetId;
        String damageStatus = req.getParameter("damageStatus");

        try {
            eventId = Integer.parseInt(req.getParameter("eventId"));
        } catch (NumberFormatException e) {
            eventId = 0;
        }
        
        if(eventDao.getEventByEventId(eventId) == null){
            return "redirect:editEvent?eventId=" + eventId;
        }

        try {
            assetId = Integer.parseInt(req.getParameter("assetId"));
        } catch (NumberFormatException e) {
            assetId = 0;
        }

        checkIn.checkInAsset(eventId, assetId, damageStatus);
        return "redirect:editEvent?eventId=" + eventId;
    }
}
