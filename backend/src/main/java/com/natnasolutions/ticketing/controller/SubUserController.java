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

@RestController
public class SubUserController {

	private static final Logger logger = LogManager.getLogger(SubUserController.class);

	@Autowired
	private SubUserService subUserService;

	@GetMapping(path = "/subuser")
	public List<SubUser> getAll() {
		return subUserService.getAllSubUsers();
	}

	@PostMapping(path = "/subuser")
	public HttpStatus insertSubUser(@RequestBody @Valid SubUser subUser) {
		return subUserService.addSubUser(subUser) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@PutMapping(path = "/subuser")
	public HttpStatus updateSubUser(@RequestBody SubUser subUser) {
		return subUserService.updateSubUser(subUser) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}

	@DeleteMapping(path = "/subuser/{id}")
	public HttpStatus deleteSubUser(@PathVariable Long id) {
		subUserService.deleteSubUser(id);
		return HttpStatus.NO_CONTENT;
	}

	@GetMapping(path = "/subuser/{id}")
	public Optional<SubUser> getSubUser(@PathVariable Long id) {
		return subUserService.getSubUser(id);
	}

	
}
