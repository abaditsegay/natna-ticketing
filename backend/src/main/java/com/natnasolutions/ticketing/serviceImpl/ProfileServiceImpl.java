package com.natnasolutions.ticketing.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.natnasolutions.ticketing.model.Event;
import com.natnasolutions.ticketing.model.Profile;
import com.natnasolutions.ticketing.repository.EventRepository;
import com.natnasolutions.ticketing.repository.ProfileRepository;
import com.natnasolutions.ticketing.service.EventService;
import com.natnasolutions.ticketing.service.ProfileService;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	public List<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

	public boolean createProfile(Profile profile) {
		return profileRepository.save(profile) != null;
	}

	public boolean updateProfile(Profile profile) {
		return profileRepository.save(profile) != null;
	}

	public boolean updateProfileByEmail(Profile profile) {
		// getting profile ID for the logged user
		int response = profileRepository.updateProfileByEmail(profile.getEmail(), profile.getId());
		if (response > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateProfileByPhonenumber(Profile profile) {
		// getting profile ID for the logged user
		int response = profileRepository.updateProfileByPhonenumber(profile.getPhonenumber(), profile.getId());
		if (response > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateProfileByName(Profile profile) {
		// getting profile ID for the logged user
		int response = profileRepository.updateProfileByName(profile.getFirstName(), profile.getLastName(),
				profile.getId());
		if (response > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateProfileByLocation(Profile profile) {
		// getting profile ID for the logged user
		int response = profileRepository.updateProfileByLocation(profile.getRegion(), profile.getCity(),
				profile.getId());
		if (response > 0) {
			return true;
		} else {
			return false;
		}
	}

}
