package com.bohdan.controller;

import com.bohdan.entity.User;
import com.bohdan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public void saveUser(User user){
        userService.save(user);
    }

    @PostMapping("/make-student")
    public ResponseEntity<String> makeUserStudent(@RequestParam int id){

        try {
            userService.makeUserStudent(id);

        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
        return ResponseEntity.ok("Статус користувача змінено на студента");
    }

}
