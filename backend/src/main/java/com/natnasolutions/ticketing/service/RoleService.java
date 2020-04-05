package com.natnasolutions.ticketing.service;

import java.util.List;
import java.util.Optional;

import com.natnasolutions.ticketing.model.Role;

public interface RoleService {

	public List<Role> getAllUserRoles();

	boolean addUserRole(Role userRole);

	public boolean updateUserRole(Role userRole);

	public void deleteUserRole(Long id);

	public Optional<Role> getUserRole(Long id);

	public List<Role> getUsereRoleByType(String roletype);

}
