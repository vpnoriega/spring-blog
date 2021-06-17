package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.daos.PostRepository;
import com.codeup.springblog.models.User;
import com.codeup.springblog.daos.UsersRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController{

    //Dependency injection: Create a Repository instance and initialize it in the controller class constructor
    private final PostRepository postDao;
    private final UsersRepository userDao;
    private final EmailService emailService;


    public PostController(PostRepository postDao, UsersRepository userDao, EmailService emailService){
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

    @GetMapping("/posts/create")
    public String viewCreateForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/posts/create")
    public String createForm(@ModelAttribute Post post){
            User user = userDao.getById(1L);
            post.setOwner(user);
            Post savedPost = postDao.save(post);
            emailService.prepareAndSend(post,"You sent a post", String.format("Here is the body of what you sent.%s %s",post.getTitle(),post.getBody())); //wherever you want to send an email is where you would tie in the email service
        return "redirect:/posts/" + savedPost.getId(); // without the / in the front of the redirect url, it will append it to the current url
    }


    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id){
       postDao.deleteById(id);
        return "redirect:/posts";
    }

//create the postMapping and getmapping(add an attribute, talk to the param, create the form, connect the two , the save method

    //First: get the same post id that is passed in to edit it:
    @GetMapping("/posts/edit/{id}")
    public String editPostForm(@PathVariable long id, Model model){
        Post post = postDao.getById(id);
        model.addAttribute("post", post);
                return "posts/edit";
    }

//Second: update and save the changes:
    @PostMapping("posts/edit/{id}")
    public String editPost(@PathVariable long id, @RequestParam(name="title") String title, @RequestParam(name="body") String body){
        Post post = postDao.getById(id); //find the post with this id in the pathVar
        post.setTitle(title); //set the new title and body
        post.setBody(body);

        postDao.save(post); //similar to create post, it needs to "save" to the database
        return "redirect:/posts/{id}";
    }


}
