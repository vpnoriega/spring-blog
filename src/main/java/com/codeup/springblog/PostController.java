package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController{
    @GetMapping("/posts")
    @ResponseBody
    public String index(){
        return "posts index page";
    }

   @RequestMapping(path="/posts/{id}", method = RequestMethod.GET) //same as: GetMapping()
    @ResponseBody
   public String viewSinglePost(@PathVariable long id){
        return "view an individual post: " + id;
    }

    @RequestMapping(path="/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String viewForm(){
        return "view the form for creating a post";
    }

    @PostMapping(path="/posts/create")
    @ResponseBody
    public String createForm(){
        return "create a new post";
    }
}
