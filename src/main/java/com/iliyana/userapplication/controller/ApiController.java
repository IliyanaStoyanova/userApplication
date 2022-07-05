package com.iliyana.userapplication.controller;

import com.iliyana.userapplication.exception.UserGenerateException;
import com.iliyana.userapplication.model.User;
import com.iliyana.userapplication.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/filter")
    public List<User> filterUsers(@RequestParam(required = false, defaultValue = "") String item,
                               @RequestParam(required = false, defaultValue = "id") String field,
                               @RequestParam(required = false, defaultValue = "asc") String dir) {
        return userService.filterUsers(item, Sort.by(Sort.Direction.fromString(dir), field));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getUsersId(@PathVariable long id){
        try {
            return new ResponseEntity(userService.getUsersId(id), HttpStatus.OK);
        }catch(UserGenerateException userGenerateException) {
            return new ResponseEntity(userGenerateException.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        }catch (UserGenerateException userGenerateException) {
            return new ResponseEntity(userGenerateException.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        try {
            return new ResponseEntity(userService.updateUser(id, user), HttpStatus.OK);
        }catch (UserGenerateException userGenerateException) {
            return new ResponseEntity(userGenerateException.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        }catch (UserGenerateException userGenerateException) {
            return new ResponseEntity(userGenerateException.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
