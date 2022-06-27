package com.iliyana.userapplication.service;

import com.iliyana.userapplication.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUsersId(long id);
    Boolean addUser(User user);
    Boolean updateUser(long id, User user);
    Boolean deleteUser(long id);
}
