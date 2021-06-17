package com.codeup.springblog.models;

import com.codeup.springblog.models.Post;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Post> posts;

    public User(){}

    //insert constructor
    public User(String email, String username, String password){
        this.email=email;
        this.username=username;
        this.password=password;
    }

    //update constructor
    public User(long id, String email, String username, String password){
        this.id=id;
        this.email=email;
        this.username=username;
        this.password=password;
    }

    //Copy constructor is used as an alternative to cloning an object. Instead of using the method clone, we create a new object using the current values of another. This will be used in order to fulfill the contract defined by the interfaces in the security package.
    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
