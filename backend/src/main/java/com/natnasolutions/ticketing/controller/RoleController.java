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

import com.natnasolutions.ticketing.model.Role;
import com.natnasolutions.ticketing.service.RoleService;
import com.natnasolutions.ticketing.util.EnConstants;
import com.natnasolutions.ticketing.util.ResponseDetails;

@RestController
public class RoleController {

	private static final Logger logger = LogManager.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	@GetMapping(path = "/role")
	public ResponseDetails getAllRoles() {
		List<Role> roleList = roleService.getAllUserRoles();
		if (roleList.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, roleList);
		}

	}

	@PostMapping(path = "/role")
	public ResponseDetails createRole(@RequestBody @Valid Role role) {
		boolean response = roleService.addUserRole(role);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@PutMapping(path = "/role")
	public ResponseDetails updateRole(@RequestBody Role role) {
		boolean response = roleService.updateUserRole(role);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@DeleteMapping(path = "/role/{id}")
	public HttpStatus deleteRole(@PathVariable Long id) {
		roleService.deleteUserRole(id);
		return HttpStatus.NO_CONTENT;
	}

	@GetMapping(path = "/role/{id}")
	public Optional<Role> getRoleById(@PathVariable Long id) {
		return roleService.getUserRole(id);
	}

	@GetMapping(path = "/role/roletype/{roletype}")
	public ResponseDetails getRoleByType(@PathVariable("roletype") String roletype) {
		List<Role> roleList = roleService.getUsereRoleByType(roletype);
		if (roleList.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, roleList);
		}
	}

}
