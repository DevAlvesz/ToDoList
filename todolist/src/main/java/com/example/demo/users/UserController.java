package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/*
 * Modificadores
 * - Public
 * - Private
 * - Protected
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody UserModel userModel){
        
        if (userService.isUserExists(userModel.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existente.");
        }

        
        var passwordHashred =  BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);

        UserModel userCreated = userService.createUser(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);

    }
}
