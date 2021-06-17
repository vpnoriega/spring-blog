package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring Boot to my friends in Marco!";
    }

//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String helloName(@PathVariable String name){
//        return "Hello from Spring Boot to " + name +" in Marco!";
//    }


    /**
     * PASSING DATA TO VIEWS NOTES
     */
    // A MODEL in this context is what Spring refers to a VIEW as. It is NOT a model in the sense that it represents data from our database
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name, Model model) {
        model.addAttribute("usersName", name);
        return "helloUser"; //looks for the html helloUser.html
    }

    /**
     * GETTING DATA FROM VIEWS NOTES
     */
    //To take in information from a View to a Controller, we can use a simple form defined with a post method in HTML.

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }
}