package com.iliyana.userapplication.controller;

import com.iliyana.userapplication.model.User;
import com.iliyana.userapplication.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ApiController {

    private final UserService userService;

    public ApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/filter")
    public List<User> filterUsers(@RequestParam(required = false, defaultValue = "") String item,
                               @RequestParam(required = false, defaultValue = "id") String field,
                               @RequestParam(required = false, defaultValue = "asc") String dir) {
        return userService.filterUsers(item, Sort.by(Sort.Direction.fromString(dir), field));
    }

    @GetMapping(value = "/{id}")
    public User getUsersId(@PathVariable long id) {
        return userService.getUsersId(id);
    }

    @PostMapping()
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping(value = "/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
