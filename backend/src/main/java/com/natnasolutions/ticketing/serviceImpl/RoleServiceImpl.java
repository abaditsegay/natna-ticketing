package com.natnasolutions.ticketing.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.natnasolutions.ticketing.model.Role;
import com.natnasolutions.ticketing.repository.RoleRepository;
import com.natnasolutions.ticketing.service.RoleService;

@Service("userRoleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository userRoleRepository;

	public boolean addUserRole(Role userRole) {
		return userRoleRepository.save(userRole) != null;
	}

	public List<Role> getAllUserRoles() {
		return userRoleRepository.findAll();
	}

	@Override
	public boolean updateUserRole(Role userRole) {
		return userRoleRepository.save(userRole) != null;
	}

	@Override
	public void deleteUserRole(Long id) {
		userRoleRepository.deleteById(id);

	}

	@Override
	public Optional<Role> getUserRole(Long id) {
		return userRoleRepository.findById(id);
	}

	@Override
	public List<Role> getUsereRoleByType(String roletype) {
		List<Role> userRoles = userRoleRepository.getUserRoles(roletype);

		return userRoles;

	}

}
