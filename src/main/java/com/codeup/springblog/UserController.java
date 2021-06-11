//package com.codeup.springblog;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class UserController {
//
//    @GetMapping("/users/all")
//    public String getAllUsers(Model model){
//        return "users";
//    }
//
//    @GetMapping("/users")
//    public String getTheStingUser(
//            Model model
//    ){
//        model.addAttribute("user", new User("Douglas","Hirsh"));
//        return "users";
//    }
//}
