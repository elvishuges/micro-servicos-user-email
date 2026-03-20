package com.ms.user.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.user.models.UserModel;
import com.ms.user.repositories.UserRepository;

@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel save(UserModel user) {
        return userRepository.save(user);
    }
    @Transactional
    public List<UserModel> getUsers() {
        return userRepository.findAll(); // Simplified for demonstration
    }
}
