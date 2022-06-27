package com.iliyana.userapplication.service;

import com.iliyana.userapplication.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    List<User> sortUsers(String field, String dir);
    User getUsersId(long id);
    Boolean addUser(User user);
    Boolean updateUser(long id, User user);
    Boolean deleteUser(long id);
}
