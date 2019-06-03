package com.geekbrains.services;

import com.geekbrains.entities.Role;
import com.geekbrains.entities.User;
import com.geekbrains.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User s) {
        s.setRoles((Collection<Role>) new Role("ROLE_USER"));
        userRepository.save(s);
    }
}
