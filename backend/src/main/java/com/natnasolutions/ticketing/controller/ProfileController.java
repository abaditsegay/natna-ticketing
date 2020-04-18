package com.natnasolutions.ticketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.natnasolutions.ticketing.model.Profile;
import com.natnasolutions.ticketing.service.ProfileService;
import com.natnasolutions.ticketing.util.EnConstants;
import com.natnasolutions.ticketing.util.ResponseDetails;

@RestController
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@GetMapping("/profile")
	public ResponseDetails getAllProfiles() {
		List<Profile> profiles = profileService.getAllProfiles();
		if (profiles.isEmpty()) {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE, profiles);
		}

	}

	@PostMapping("/profile")
	public ResponseDetails createProfile(@RequestBody Profile profile) {
		boolean response = profileService.createProfile(profile);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@PutMapping("/profile")
	public ResponseDetails updateProfile(@RequestBody Profile profile) {
		boolean response = profileService.updateProfile(profile);
		if (response) {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.VALIDATION_FAILURE_CODE, EnConstants.VALIDATION_FAILURE_MESSAGE);
		}

	}

	@PutMapping("/profile/email")
	public ResponseDetails updateProfileByEmail(@RequestBody Profile profile) {
		boolean response = profileService.updateProfileByEmail(profile);
		if (!response) {
			return new ResponseDetails(EnConstants.RECORD_NOT_FOUND_CODE, EnConstants.RECORD_NOT_FOUND_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		}
	}

	@PutMapping("/profile/phonenumber")
	public ResponseDetails updateProfileByPhonenumber(@RequestBody Profile profile) {
		boolean response = profileService.updateProfileByPhonenumber(profile);
		if (!response) {
			return new ResponseDetails(EnConstants.RECORD_NOT_FOUND_CODE, EnConstants.RECORD_NOT_FOUND_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		}
	}

	@PutMapping("/profile/myinfo")
	public ResponseDetails updateProfileByName(@RequestBody Profile profile) {
		boolean response = profileService.updateProfileByName(profile);
		if (!response) {
			return new ResponseDetails(EnConstants.RECORD_NOT_FOUND_CODE, EnConstants.RECORD_NOT_FOUND_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		}
	}

	@PutMapping("/profile/address")
	public ResponseDetails updateProfileByLocation(@RequestBody Profile profile) {
		boolean response = profileService.updateProfileByLocation(profile);
		if (!response) {
			return new ResponseDetails(EnConstants.RECORD_NOT_FOUND_CODE, EnConstants.RECORD_NOT_FOUND_MESSAGE);
		} else {
			return new ResponseDetails(EnConstants.SUCCESS_CODE, EnConstants.SUCCESS_MESSAGE);
		}
	}

}
