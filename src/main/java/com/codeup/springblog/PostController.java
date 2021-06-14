package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController{

    //Dependency injection: Create a Repository instance and initialize it in the controller class constructor
    private final PostRepository postDao;
    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model model){
        List<Post> PostList = new ArrayList<>();
        PostList.add(new Post("Phonecase", "Old school phone case from the 90s"));
        PostList.add(new Post("Headphones", "Old school wire headphones"));
//views ex:
// model.addAttribute("currentPosts", PostList);

 //jpa ex:
        model.addAttribute("currentPosts",postDao.findAll());
        return "posts/index";
    }

   @RequestMapping(path="/posts/{id}", method = RequestMethod.GET) //same as: GetMapping()
   public String viewSinglePost(@PathVariable long id, Model model){
       model.addAttribute("singlePost", new Post("Cassette Player", "Comes with batteries"));
        return "posts/show";
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
