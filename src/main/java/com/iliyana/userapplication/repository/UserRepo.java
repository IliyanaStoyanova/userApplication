package com.iliyana.userapplication.repository;

import com.iliyana.userapplication.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u" +
            " WHERE u.firstName LIKE CONCAT('%',:item, '%')" +
            " OR u.lastName LIKE CONCAT('%', :item, '%')")
    List<User> filterUsers(String item, Sort sort);
}
