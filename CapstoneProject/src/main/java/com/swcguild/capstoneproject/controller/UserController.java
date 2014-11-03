/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class UserController {
    
    @RequestMapping(value="/viewAllUsers", method = RequestMethod.GET)
    public String viewAllUsers(){
        return "viewAllUsers";
    }
    
    @RequestMapping(value="/addUser", method = RequestMethod.GET)
    public String addUser(){
        return "addUser";
    }
    
}
