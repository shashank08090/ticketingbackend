package com.example.hello_world.controller;

import com.example.hello_world.entity.User;
import com.example.hello_world.repository.UserRepository;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET API to fetch all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // POST API to create a new user
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        // Save user to the database and return the saved user object
        return userRepository.save(user);
    }

    // Example endpoint to demonstrate a custom message
    @GetMapping("/mycode")
    public String myCode() {
        return "Welcome to the API !!";
    }
}
