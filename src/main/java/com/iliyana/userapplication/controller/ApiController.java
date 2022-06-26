package com.iliyana.userapplication.controller;

import com.iliyana.userapplication.model.User;
import com.iliyana.userapplication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public User getUsersId(@PathVariable long id) {
        return userRepo.findById(id).get();
    }
    @PostMapping(value = "/users")
    public String addUser(@RequestBody User user) {
        userRepo.save(user);
        return "Saved...";
    }

    @PutMapping(value = "/users/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setDateBirth(user.getDateBirth());
        updatedUser.setPhoneNumber(user.getPhoneNumber());
        updatedUser.setEmailAddress(user.getEmailAddress());
        userRepo.save(updatedUser);
        return "Updated...";
    }

    @DeleteMapping(value = "/users/{id}")
    public String deleteUser(@PathVariable long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Delete user with the id: " + id;
    }
}
