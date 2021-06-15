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
    private final UserRepository userDao;
    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }



    @GetMapping("/posts")
    public String index(Model model){
//        List<Post> PostList = new ArrayList<>();
//        PostList.add(new Post("Phonecase", "Old school phone case from the 90s"));
//        PostList.add(new Post("Headphones", "Old school wire headphones"));
//views ex)
// model.addAttribute("currentPosts", PostList);

 //jpa ex:
        model.addAttribute("currentPosts",postDao.findAll());
        return "posts/index";
    }

   @RequestMapping(path="/posts/{id}", method = RequestMethod.GET) //same as: GetMapping()
   public String viewSinglePost(@PathVariable long id, Model model){
       model.addAttribute("singlePost", postDao.getById(id));
        return "posts/show";
    }

    @RequestMapping(path="/posts/create", method = RequestMethod.GET)
    public String viewCreateForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping(path="/posts/create")
    public String createForm(@ModelAttribute Post post){
            User user = userDao.getById(1L);
            post.setOwner(user);
            Post savedPost = postDao.save(post);
        return "redirect:/posts/" + savedPost.getId();
    }

    // without the / in the front of the redirect url, it will append it to the current url

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }


//create the postMapping and getmapping(add an attribute, talk to the param, create the form, connect the two , the save method

}
