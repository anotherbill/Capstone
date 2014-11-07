/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.controller;

import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.model.Event;
import java.util.Set;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping({"/"})
public class HomeController {
    
    private EventInterface eventDao;
    
    @Inject
    public void setEventDao(EventInterface eventDao) {
        this.eventDao = eventDao;
    }
    
    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String home(Model model) {
        Set<Event> eventList = eventDao.getAllEvents();
        model.addAttribute("eventList", eventList);
        return "index";
    }
}
