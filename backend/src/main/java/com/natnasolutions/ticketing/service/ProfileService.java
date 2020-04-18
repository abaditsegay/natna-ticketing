package com.natnasolutions.ticketing.service;

import java.util.Date;
import java.util.List;

import com.natnasolutions.ticketing.model.Event;
import com.natnasolutions.ticketing.model.Profile;

public interface ProfileService {

	public List<Profile> getAllProfiles();

	public boolean createProfile(Profile profile);

	public boolean updateProfile(Profile profile);

	public boolean updateProfileByEmail(Profile email);

	public boolean updateProfileByPhonenumber(Profile profile);

	public boolean updateProfileByName(Profile profile);

	public boolean updateProfileByLocation(Profile profile);

}
