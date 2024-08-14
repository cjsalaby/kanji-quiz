package com.cjsalabye.quiz.controller;

import com.cjsalabye.quiz.dto.UserRegistrationDTO;
import com.cjsalabye.quiz.model.User;
import com.cjsalabye.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        System.out.println(userRegistrationDTO.getUsername());
        System.out.println(userRegistrationDTO.getPassword());
        return userService.registerUser(userRegistrationDTO.getUsername(), userRegistrationDTO.getPassword());
    }

}
