package com.natnasolutions.ticketing.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.natnasolutions.ticketing.model.SubUser;
import com.natnasolutions.ticketing.model.User;
import com.natnasolutions.ticketing.repository.SubUserRepository;
import com.natnasolutions.ticketing.repository.UserRepository;
import com.natnasolutions.ticketing.service.SubUserService;

@Service
@Transactional
public class SubUserServiceImpl implements SubUserService {

	@Autowired
	private SubUserRepository subUserRepository;

	@Autowired
	private UserRepository userRepository;

	public boolean addSubUser(SubUser subUser) {
		User user = new User();
		user.setId((long) 1);

		subUser.setUser(user);

		return subUserRepository.save(subUser) != null;
	}

	public List<SubUser> getAllSubUsers() {
		return subUserRepository.findAll();
	}

	@Override
	public boolean updateSubUser(SubUser subUser) {
		return subUserRepository.save(subUser) != null;
	}

	@Override
	public List<SubUser> getSubUser(String email) {
		return subUserRepository.getSubUserByEmail(email);
	}

}
