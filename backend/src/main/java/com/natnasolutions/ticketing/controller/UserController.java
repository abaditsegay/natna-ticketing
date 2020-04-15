package com.natnasolutions.ticketing.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseDetails getAllUsers() {
		List<User> userList = userService.getAllUsers();
		if (userList.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, userList);
		}

	}

	@PostMapping(path = "/user")
	public ResponseDetails createUser(@RequestBody User user) {
		boolean response = userService.addUser(user);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@PutMapping(path = "/user")
	public ResponseDetails updateUser(@RequestBody User user) {
		boolean response = userService.updateUser(user);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

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
	public ResponseDetails getUsereByName(@PathVariable String email) {
		List<User> userList = userService.findByName(email);
		if (userList.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, userList);
		}

	}

	@GetMapping(path = "/user/login")
	public boolean signIn(@RequestBody User user) {
		return false;
	}

	@PostMapping(path = "/user/forgotpassword/{email}")
	public ResponseDetails forgotPassword(@PathVariable String email) {
		boolean response = userService.forgotPassword(email);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@PutMapping(path = "user/updatepassword")
	public ResponseDetails updatePassword(@RequestBody User user) {
		boolean response = userService.updatePassword(user);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}
	}

	@GetMapping(path = "/user/getUsersByStatus/{status}")
	public List<User> getAllUsersByStatus(@PathVariable boolean status) {
		return null;
	}

}
