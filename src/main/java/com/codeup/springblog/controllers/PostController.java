package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.daos.PostRepository;
import com.codeup.springblog.models.User;
import com.codeup.springblog.daos.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController{

    //Dependency injection: Create a Repository instance and initialize it in the controller class constructor
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;


    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
            emailService.prepareAndSend(post,"You sent a post", String.format("Here is the body of what you sent.%s %s",post.getTitle(),post.getBody()));
        return "redirect:/posts/" + savedPost.getId();
    } //wherever you want to send an email is where you would tie in the email service

    // without the / in the front of the redirect url, it will append it to the current url

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }


//create the postMapping and getmapping(add an attribute, talk to the param, create the form, connect the two , the save method


}
