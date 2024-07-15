package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
 
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name","Sonu Kumar Singh");
        model.addAttribute("Village","Badheya");
        model.addAttribute("gitthub", "https://github.com/Sonu1996kumar");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage(){
        return "about";
    }


    @RequestMapping("/services")
    public String servicesPage(){
        return "services";
    }
}
