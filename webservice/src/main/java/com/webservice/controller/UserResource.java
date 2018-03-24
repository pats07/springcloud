package com.webservice.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webservice.domain.User;
import com.webservice.exception.UserNotFoundException;
import com.webservice.service.UserService;

@RestController
public class UserResource {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		List<User> users = userService.getAllUsers();
		System.out.println(users);
		return users;
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		User user = userService.getUserById(id);
		if (user == null) {
			throw new UserNotFoundException("Id : " + id);
		}
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User savedUser = userService.addUser(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id")Integer id) {
		User user = userService.deleteUser(id);
		if(user == null) 
			throw new UserNotFoundException("Id : "+ id);
				
	}
	
}
