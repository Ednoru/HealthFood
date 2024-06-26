package com.example.healthfood.application.service;


import com.example.healthfood.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.healthfood.domain.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUser() {return userRepository.findAll();}
    public User getUserById(Long id) {return userRepository.findById(id).orElse(null);}
    public User addUser(User user) {return userRepository.save(user);}
    public void deleteUser(Long id) {userRepository.deleteById(id);}

}
