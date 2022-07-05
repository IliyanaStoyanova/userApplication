package com.iliyana.userapplication.service.impl;

import com.iliyana.userapplication.exception.UserGenerateException;
import com.iliyana.userapplication.model.User;
import com.iliyana.userapplication.repository.UserRepo;
import com.iliyana.userapplication.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<User> filterUsers(String item, Sort sort) {
        return userRepo.filterUsers(item, sort);
    }
    @Override
    public User getUsersId(long id) {
        if(userRepo.findById(id).isEmpty()) {
            throw new UserGenerateException("User NOT FOUND");
        }
        return userRepo.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        if(userRepo.existsByEmailAddress(user.getEmailAddress())) {
            throw new UserGenerateException("The User EXISTS!");
        }
        return userRepo.save(user);
    }

    @Override
    public User updateUser(long id, User user) {
        if(userRepo.findById(id).isEmpty()) {
            throw new UserGenerateException("User NOT FOUND");
        }
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setDateBirth(user.getDateBirth());
        updatedUser.setPhoneNumber(user.getPhoneNumber());
        updatedUser.setEmailAddress(user.getEmailAddress());
        return userRepo.save(updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        if(userRepo.findById(id).isEmpty()) {
            throw new UserGenerateException("User NOT FOUND");
        }
        userRepo.deleteById(id);
    }
}
