/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.controller;

import com.swcguild.capstoneproject.dao.interfaces.UserInterface;
import com.swcguild.capstoneproject.model.User;
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
public class UserController {

    private UserInterface userDao;
    
    @Inject
    public UserController(UserInterface userDao) {
        this.userDao = userDao;
    }
    
    
    @RequestMapping(value="/viewAllUsers", method = RequestMethod.GET)
    public String viewAllUsers(Model model){
        Set<User> userList = userDao.getAllUsers();
        model.addAttribute("userList", userList);
        return "viewAllUsers";
    }
    
    @RequestMapping(value="/addUser", method = RequestMethod.GET)
    public String displayAddUserForm(Model model){
        model.addAttribute("newUser", new User());
        return "addUser";
    }
    
    @RequestMapping(value="/submitNewUser", method = RequestMethod.POST)
    public String addNewUserToDatabase(@ModelAttribute("newUser") User newUser, Model model, HttpServletRequest request){
        userDao.addUser(newUser);
        return "redirect:viewAllUsers";
    }
    
    @RequestMapping(value="/deleteUser", method=RequestMethod.GET)
    public String deleteUser(@RequestParam("userId") int userId, Model model, HttpServletRequest req){
        
        userDao.deleteUser(userDao.getUserByUserId(userId));
        return "redirect:viewAllUsers";
    }
    
}
