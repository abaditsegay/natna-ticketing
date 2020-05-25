package com.natnasolutions.ticketing.service;

import java.util.List;
import java.util.Optional;

import com.natnasolutions.ticketing.model.Role;

public interface RoleService {

	public List<Role> getAllRoles();

	boolean addRole(Role userRole);

	public boolean updateRole(Role userRole);

	public void deleteUserRole(Long id);

	public Optional<Role> getUserRole(Long id);

	public List<Role> getUsereRoleByType(String roletype);

}
