package com.natnasolutions.ticketing.service;

import java.util.List;
import java.util.Optional;

import com.natnasolutions.ticketing.model.SubUser;

public interface SubUserService {

	public List<SubUser> getAllSubUsers();

	boolean addSubUser(SubUser subUser);

	public boolean updateSubUser(SubUser subUser);

	public List<SubUser> getSubUser(String email);

}
