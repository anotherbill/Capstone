package com.swcguild.capstoneproject.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/"})
public class HomeController {
        
    public HomeController() {
    }
    
    @RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
    public String home() {
        return "index";
    }
}
