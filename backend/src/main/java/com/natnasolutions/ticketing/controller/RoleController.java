package com.natnasolutions.ticketing.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.UniqueConstraint;
import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.natnasolutions.ticketing.model.User;
import com.natnasolutions.ticketing.model.Role;
import com.natnasolutions.ticketing.service.RoleService;
import com.natnasolutions.ticketing.util.RecordAlreadyFoundException;

@RestController
public class RoleController {

	private static final Logger logger = LogManager.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	@GetMapping(path = "/role")
	public List<Role> getAll() {
		return roleService.getAllUserRoles();
	}

	@PostMapping(path = "/role")
	public HttpStatus insertUserRole(@RequestBody @Valid Role role) {
		return roleService.addUserRole(role) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@PutMapping(path = "/role")
	public HttpStatus updateUserRole(@RequestBody Role role) {
		return roleService.updateUserRole(role) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}

	@DeleteMapping(path = "/role/{id}")
	public HttpStatus deleteUserRole(@PathVariable Long id) {
		roleService.deleteUserRole(id);
		return HttpStatus.NO_CONTENT;
	}

	@GetMapping(path = "/role/{id}")
	public Optional<Role> getUserRole(@PathVariable Long id) {
		return roleService.getUserRole(id);
	}

	@GetMapping(path = "/role/roletype/{roletype}")
	public Optional<Role> getUsereRoleByType(@PathVariable("roletype") String roletype) {
		return roleService.getUsereRoleByType(roletype);
	}

}
