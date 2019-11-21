package com.example.demo.controllers;

import com.example.demo.entities.Privilege;
import com.example.demo.entities.User;
import com.example.demo.entities.enums.Authorities;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class TestController {

	private UserRepository userRepository;

	@Autowired
	public TestController(UserRepository userRepository) {
		this.userRepository = userRepository;
		User user = new User();
		user.setUsername("user");
		user.setPassword("pass");
		user.setMatchStatus("matched");
		user.setTenant("US");
		Collection<Privilege> roleEntities = new ArrayList<>();
		Privilege loginPrivilege = new Privilege();
		loginPrivilege.setAuthority(Authorities.LOGIN);
		roleEntities.add(loginPrivilege);

		user.setGrantedRoles(roleEntities);

		userRepository.saveAndFlush(user);
	}

	@GetMapping(value = "/signup")
	public String signup() {
		return "signup.html";
	}

	@PostMapping(value = "/signup")
	public ResponseEntity createUser(@RequestParam String username, @RequestParam String password, @RequestParam String matchStatus, @RequestParam String tenant) {
		ResponseEntity responseEntity;

		 User user = userRepository.findByUsernameWithGrantedRoles(username);
		if (user != null) {
			responseEntity = ResponseEntity.badRequest().body("username already exists");
		} else {
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setPassword(password);
			newUser.setMatchStatus(matchStatus);
			newUser.setTenant(tenant);
			userRepository.save(newUser);
			responseEntity = ResponseEntity.ok().body("User created successfully");
		}

		return responseEntity;
	}

	@GetMapping(value = "/login")
	public String login() {
		return "login.html";
	}

	@PostMapping(value = "/login")
	public ResponseEntity login(@RequestParam String username, @RequestParam String password) {
		System.out.println();
		return ResponseEntity.ok().build();
	}
}
