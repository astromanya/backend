package com.internet.site.controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internet.site.entitys.User;
import com.internet.site.repos.IUserRepo;
import com.internet.site.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		return userService.getOneUser(userId);
	}
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
	}
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser) {
		return userService.updateUser(userId, newUser);
		}
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteById(userId);
			
	}
	}
	
	

