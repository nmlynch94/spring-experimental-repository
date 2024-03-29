package com.example.demo.controllers;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.mappers.UserMapper;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    private UserMapper userMapper;

    private UserRepository userRepository;

    @Autowired
    public UserController(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/users/{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("username") String username) {
        User user = userRepository.findByUsername(username);
        ResponseEntity<UserDTO> responseEntity = ResponseEntity.ok(userMapper.toDTO(user));
        return responseEntity;
    }

    @GetMapping(value = "/users/sample")
    public ResponseEntity<UserDTO> getSampleUser() {
        User sampleUser = new User();
        sampleUser.setId(111L);
        sampleUser.setUsername("");
        ResponseEntity<UserDTO> responseEntity = ResponseEntity.ok(userMapper.toDTO(sampleUser));
        return responseEntity;
    }

}
