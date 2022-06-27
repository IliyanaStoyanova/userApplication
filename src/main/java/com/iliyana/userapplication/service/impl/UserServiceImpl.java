package com.iliyana.userapplication.service.impl;

import com.iliyana.userapplication.model.User;
import com.iliyana.userapplication.repository.UserRepo;
import com.iliyana.userapplication.service.UserService;
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
    public User getUsersId(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public Boolean addUser(User user) {
        userRepo.save(user);
        return true;
    }

    @Override
    public Boolean updateUser(long id, User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setDateBirth(user.getDateBirth());
        updatedUser.setPhoneNumber(user.getPhoneNumber());
        updatedUser.setEmailAddress(user.getEmailAddress());
        userRepo.save(updatedUser);
        return true;
    }

    @Override
    public Boolean deleteUser(long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return true;
    }
}
