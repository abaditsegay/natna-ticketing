package com.natnasolutions.ticketing.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natnasolutions.ticketing.model.SubUser;
import com.natnasolutions.ticketing.service.SubUserService;
import com.natnasolutions.ticketing.util.EnConstants;
import com.natnasolutions.ticketing.util.ResponseDetails;

@RestController
public class SubUserController {

	private static final Logger logger = LogManager.getLogger(SubUserController.class);

	@Autowired
	private SubUserService subUserService;

	@GetMapping(path = "/subuser")
	public ResponseDetails getAllSubUsers() {
		List<SubUser> subUserList = subUserService.getAllSubUsers();
		if (subUserList.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, subUserList);
		}
	}

	@PostMapping(path = "/subuser")
	public ResponseDetails createSubUser(@RequestBody @Valid SubUser subUser) {
		boolean response = subUserService.addSubUser(subUser);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@PutMapping(path = "/subuser")
	public ResponseDetails updateSubUser(@RequestBody SubUser subUser) {
		boolean response = subUserService.updateSubUser(subUser);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@GetMapping(path = "/subuser/{email}")
	public ResponseDetails getSubUserByEmail(@PathVariable String email) {
		List<SubUser> subUserList = subUserService.getSubUser(email);
		if (subUserList.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, subUserList);
		}

	}

}
