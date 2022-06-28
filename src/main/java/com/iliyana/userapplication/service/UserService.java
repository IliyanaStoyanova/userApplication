package com.iliyana.userapplication.service;

import com.iliyana.userapplication.model.User;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    List<User> filterUsers(String item, Sort sort);
    User getUsersId(long id);
    User addUser(User user);
    User updateUser(long id, User user);
    void deleteUser(long id);
}
