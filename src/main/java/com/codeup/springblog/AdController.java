package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdController {
    // These two next steps are often called dependency injection, where we create a Repository instance and initialize it in the controller class constructor.
    private final AdRepository adDao;


    public AdController(AdRepository adDao){ //initialize it in the class constructor
        this.adDao = adDao; //repository instance
    }
    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        model.addAttribute("topAd", adDao.findByTitle("bicycle north side"));
        return "adIndex";
    }
}
