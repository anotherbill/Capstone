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

    private static final String BAD_EVENT_ERROR_MESSAGE = "Oops! Invalid event ID. Must supply event ID as an integer. Event ID must refer to an existing Event.";
    private static final String BAD_ASSET_ERROR_MESSAGE = "Oops! Invalid asset ID. Must supply asset ID as an integer. Asset ID must refer to an existing asset.";

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
    public String showEditEventPage(Model model, HttpServletRequest request) {
        int eventId;
        String badAssetError;
        List<Date> returnDates = new ArrayList<>();
        Event eventToEdit;
        List<Asset> assetsCheckedOutForEvent;
        Set<Category> categoryList;
        Set<AssetType> assetTypeList;
        
        //retrieve selected event
        try{
            eventId = Integer.parseInt(request.getParameter("eventId"));
        }
        catch(NumberFormatException e){
            eventId = 0;
        }
        
        eventToEdit = eventDao.getEventByEventId(eventId);
        
        if(eventToEdit == null){
            model.addAttribute("badEventError", BAD_EVENT_ERROR_MESSAGE);
            return "redirect:home";
        }
        model.addAttribute("event", eventToEdit);

        //retrieve asset associated with event
        assetsCheckedOutForEvent = new ArrayList<>();
        assetsCheckedOutForEvent.addAll(eventDao.getAllAssetsForEvent(eventToEdit));
        model.addAttribute("assetCheckedOutList", assetsCheckedOutForEvent);
        
        //retrieve return dates (if any) for each asset in order
        for (Asset a : assetsCheckedOutForEvent) {
            returnDates.add(checkIn.getReturnDate(eventId, a.getAssetId()));
        }
        model.addAttribute("returnDates", returnDates);

        //retrieve categories and asset types
        categoryList = assetDao.getAllCategories();
        model.addAttribute("categoryList", categoryList);

        assetTypeList = assetDao.getAllAssetTypes();
        model.addAttribute("assetTypeList", assetTypeList);
        
        //error message
        badAssetError = request.getParameter("badAssetError");
        model.addAttribute("badAssetError", badAssetError);

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

        if (eventDao.getEventByEventId(eventId) == null) {
            model.addAttribute("badEventError", BAD_EVENT_ERROR_MESSAGE);
            return "redirect:home";
        }

        try {
            assetId = Integer.parseInt(req.getParameter("assetId"));
        } catch (NumberFormatException e) {
            assetId = 0;
        }

        if(assetDao.getAssetById(assetId) == null){
            model.addAttribute("badAssetError", BAD_ASSET_ERROR_MESSAGE);
            return "redirect:editEvent?eventId=" + eventId;
        }
        
        checkIn.checkInAsset(eventId, assetId, damageStatus);
        return "redirect:editEvent?eventId=" + eventId;
    }
}
