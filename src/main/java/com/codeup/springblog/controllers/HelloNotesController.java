package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //defines the class of the controller
public class HelloNotesController {
    @GetMapping("/hellonotes") // defines the method that should be invoked when a GET request is received from the URI
    @ResponseBody //tells spring that whatever is returned should be in the BODY of our response
    public String hello(){
        return "Hello there from my notes!";
    }

    //path variables are part of the URI or a request as opposed to being passed as a query string
    @GetMapping("/hellonotes/{fruit}")
    @ResponseBody
    public String sayHello(@PathVariable String fruit){
        return "There are 5 " + fruit + " left in the fruit basket";
    }

    //Defining the parameter with a different type.
    //@RequestMapping annotation is the longer version of @GetMapping
    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }
}

