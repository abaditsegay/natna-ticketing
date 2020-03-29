package com.natnasolutions.ticketing.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.natnasolutions.ticketing.model.User;
import com.natnasolutions.ticketing.model.Role;
import com.natnasolutions.ticketing.repository.UserRepository;
import com.natnasolutions.ticketing.repository.RoleRepository;
import com.natnasolutions.ticketing.service.RoleService;
import com.natnasolutions.ticketing.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleService userRoleService;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public boolean addUser(User user) {
		Optional<Role> userRole = userRoleService.getUsereRoleByType("Admin2");
		user.addRole(userRole.get());

		return userRepository.save(user) != null;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		return userRepository.save(user) != null;
	}

	@Override
	public boolean signIn(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String forgotPassword(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsersByStatus(boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

}
