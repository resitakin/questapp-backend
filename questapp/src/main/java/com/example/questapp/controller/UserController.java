package com.example.questapp.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.questapp.entities.User;
import com.example.questapp.services.UserService;

@RestController
@RequestMapping("/users")

public class UserController {
	
	private UserService userService;

	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUser();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
		
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		//custom exception
		return userService.getOneUserById(userId);
		
	}
	
	@PutMapping("{userId}")
	public User getUpdateUser(@PathVariable Long userId , @RequestBody User newUser ) {
		return userService.updateOneUser(userId,newUser);
		
	}
	
	
	@DeleteMapping("/userId")

	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteOneUser(userId);
		
		
	}
	

}
