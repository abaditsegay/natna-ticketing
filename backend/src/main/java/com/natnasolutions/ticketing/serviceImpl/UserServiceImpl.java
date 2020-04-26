package com.natnasolutions.ticketing.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.natnasolutions.ticketing.model.Role;
import com.natnasolutions.ticketing.model.User;
import com.natnasolutions.ticketing.repository.UserRepository;
import com.natnasolutions.ticketing.service.RoleService;
import com.natnasolutions.ticketing.service.UserService;

@Service
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
		List<Role> userRole = userRoleService.getUsereRoleByType(user.getRole());
		user.addRole(userRole.get(0));

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
	public List<User> findByName(String email) {
		return userRepository.getUserbyEmail(email);
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
	public boolean forgotPassword(String email) {
		List<User> userList = findByName(email);
		if (userList.isEmpty()) {
			return false;
		} else {
			// making an async call service to send an email to the use
			return true;
		}
	}

	@Override
	public boolean updatePassword(User user) {
		List<User> userList = findByName(user.getUsername());
		if (userList.isEmpty()) {
			return false;
		} else {
			User LoggedUser = userList.get(0);
			LoggedUser.setPassword(user.getPassword());
			boolean response = userRepository.save(LoggedUser) != null;
			if (!response) {
				return false;
			}
			return true;
		}
	}

	@Override
	public List<User> getAllUsersByStatus(boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

}
