package com.natnasolutions.ticketing.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.natnasolutions.ticketing.model.User;
import com.natnasolutions.ticketing.service.UserService;
import com.natnasolutions.ticketing.util.EnConstants;
import com.natnasolutions.ticketing.util.ResponseDetails;

@RestController
public class UserController {
	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping(path = "/user")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping(path = "/user")
	public ResponseDetails insertUser(@RequestBody User user) {
		boolean response = userService.addUser(user);
		ResponseDetails responseDetails = null;
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, "User was created succesfully");
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, "User was not created succesfully");
		}

	}

	@PutMapping(path = "/user")
	public HttpStatus updateUser(@RequestBody User user) {
		return userService.updateUser(user) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}

	@PatchMapping(path = "/user")
	public HttpStatus patchUser(@RequestBody User user) {
		return userService.updateUser(user) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}

	@DeleteMapping(path = "/user/{id}")
	public HttpStatus deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return HttpStatus.NO_CONTENT;
	}

	@GetMapping(path = "/user/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@GetMapping(path = "user/username/{email}")
	public List<User> getUsereByName(@PathVariable String name) {
		return userService.findByName(name);
	}

	@GetMapping(path = "/user/login")
	public boolean signIn(@RequestBody User user) {
		return false;
	}

	@PostMapping(path = "/user/forgotpassword/{email}")
	public String forgotPassword(@PathVariable String email) {
		return null;
	}

	@PutMapping(path = "user/updatepassword")
	public String updatePassword(@RequestBody User user) {
		return null;
	}

	@GetMapping(path = "/user/getUsersByStatus/{status}")
	List<User> getAllUsersByStatus(@PathVariable boolean status) {
		return null;
	}

}
