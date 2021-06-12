package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello from Spring Boot to my friends in Marco!";
    }

//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String helloName(@PathVariable String name){
//        return "Hello from Spring Boot to " + name +" in Marco!";
//    }


    /** PASSING DATA TO VIEWS NOTES*/
    // A MODEL in this context is what Spring refers to a VIEW as. It is NOT a model in the sense that it represents data from our database
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name, Model model){
        model.addAttribute("usersName", name);
        return "helloUser"; //looks for the html helloUser.html
    }
}
