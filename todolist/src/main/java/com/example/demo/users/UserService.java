package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public boolean isUserExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }
}
