package com.example.wbdvsp20jannunziserverjava.controllers;

import com.example.wbdvsp20jannunziserverjava.models.User;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {
    @Autowired
    UserRepository repository;
    @PostMapping("/register")
    public User register(
            HttpSession session,
            @RequestBody User user) {
        User newUser = repository.save(user);
        newUser.setPassword("***");
        session.setAttribute("profile", newUser);
        return newUser;
    }
    @PostMapping("/profile")
    public User profile(HttpSession session) {
        User profile = (User)session.getAttribute("profile");
        profile.setPassword("***");
        return profile;
    }
}
