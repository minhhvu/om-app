package com.minhvu.omapp.backend.controller;

import com.minhvu.omapp.backend.model.User;
import com.minhvu.omapp.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String signup(){
        User user = new User();
        user.setEmail("abc@admin.com");
        user.setName("abc");
        userRepository.save(user);
        return "saved";
    }

    @GetMapping("/test")
    public String test(){
        return "abc";
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers(@RequestHeader HttpHeaders header){
        System.out.println(header.keySet());
        System.out.println(header);
        return userRepository.findAll();
    }

    @GetMapping("/1")
    public User getUser(){
        User user = userRepository.findUserById(1L);
        return user;
    }

}
