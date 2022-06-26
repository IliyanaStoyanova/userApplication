package com.iliyana.userapplication.repository;

import com.iliyana.userapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
