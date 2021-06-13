package com.codeup.springblog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Creating the controller that returns a view:
@Controller
public class ViewNotesHomeController {
    @GetMapping("/home")
    public String welcome(){
        return "home";
    }
}

//We have the @Controller and @GetMapping annotation, but no @ResponseBody annotation
//We need to create a home.html because our application configures Spring to resolve view names returned from controller methods. So when the string "home" is returned in the controller, Spring will try to find a file named home.html inside of the resources/templates
