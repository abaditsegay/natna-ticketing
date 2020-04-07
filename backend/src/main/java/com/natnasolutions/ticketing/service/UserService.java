package com.natnasolutions.ticketing.service;

import java.util.List;
import java.util.Optional;

import com.natnasolutions.ticketing.model.User;

public interface UserService {

	List<User> getAllUsers();

	boolean addUser(User user);

	void deleteUser(Long id);

	public Optional<User> getUserById(Long id);

	List<User> findByName(String name);

	boolean updateUser(User user);

	boolean signIn(User user);

	boolean forgotPassword(String email);

	boolean updatePassword(User user);

	List<User> getAllUsersByStatus(boolean status);

}
