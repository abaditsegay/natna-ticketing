package com.natnasolutions.ticketing.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.natnasolutions.ticketing.model.Role;
import com.natnasolutions.ticketing.repository.RoleRepository;
import com.natnasolutions.ticketing.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public boolean addRole(Role role) {
		return roleRepository.save(role) != null;
	}

	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public boolean updateRole(Role role) {
		return roleRepository.save(role) != null;
	}

	@Override
	public void deleteUserRole(Long id) {
		roleRepository.deleteById(id);

	}

	@Override
	public Optional<Role> getUserRole(Long id) {
		return roleRepository.findById(id);
	}

	@Override
	public List<Role> getUsereRoleByType(String roletype) {
		List<Role> roles = roleRepository.getUserRoles(roletype);

		return roles;

	}

}
