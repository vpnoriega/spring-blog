package com.codeup.springblog.controllers;

import com.codeup.springblog.daos.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Dependency Injection is a fancy way to say passing objects into the constructor of an object.
// The following example shows how we can inject AdRepository into our AdController:
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
        model.addAttribute("searchAd", adDao.findByTitleLike("%childcare%"));
        return "adIndex";
    }
}

/**By extending JpaRepository, we inherit the CRUD functionality that the Spring framework provides, including methods for retrieving an Iterable Interface1 with all the ads (findAll), a specific ad (getOne), inserting or updating an ad (save), and deleting an ad (delete).*/

/** whatever gets selected will get passed through */
//<select multiple="multiple" th:field="${ad.categories}" class="form-control">
//<option th:each="category: ${categories}" th:value="${category.id}" th:text="${category.name}"></option>
//</select>
//
/** Idea Two: The Div Path
//whatever the check box is , it will apply the field */

//<div th:each="category : ${categories}">
//<label th:class="${'category' + category.getId()}">
//<input name="interests" type="checkbox" th:field="*{categories}" th:value="${category.getId()}" th:text="${category.getName()}"/>
//</label>
//</div>

//list of cats, checked the dao, controller, got cats and sent to a view in a category, iterated the cats and hooked it up through form model binding