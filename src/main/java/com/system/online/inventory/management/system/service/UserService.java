package com.system.online.inventory.management.system.service;

import com.system.online.inventory.management.system.model.User;
import com.system.online.inventory.management.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User updateUsers(Integer id) {
        return userRepository.findById(id).get();
    }

    public void deleteUsers(Integer id) {
        userRepository.deleteById(id);
    }
}
