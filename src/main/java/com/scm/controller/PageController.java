package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entity.User;

import com.scm.forms.UserForm;
import com.scm.services.UserService;

@Controller
public class PageController {
 
    @Autowired
    private UserService userService;
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

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register( Model model ){
        //default data bhi daal sakte hai
        UserForm userForm = new UserForm();
        model.addAttribute("userForm",userForm);
        return "register";
    }

    //processing register

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println("Processing register");
        //fetch form data
        //userFormData
        //validate form data
        //save data to database
        //UserForm->User
        User user = User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .profilePic("https://www.istockphoto.com/search/2/image-film?phrase=default+profile+image")
        .build();

        User saveUser = userService.saveUser(user);

        //message ="register successfully"
        //redirect to login page
        
        return "redirect:/register";
    }
}
