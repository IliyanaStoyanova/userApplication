package com.iliyana.userapplication.service;

import com.iliyana.userapplication.model.User;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    List<User> filterUsers(String item, Sort sort);
    User getUsersId(long id);
    Boolean addUser(User user);
    Boolean updateUser(long id, User user);
    Boolean deleteUser(long id);
}
