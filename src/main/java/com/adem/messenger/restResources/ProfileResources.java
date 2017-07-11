package com.adem.messenger.restResources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adem.messenger.entities.Profile;
import com.adem.messenger.service.ProfileService;

@RestController
public class ProfileResources {

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	public List<Profile> getAllProfile() {
		return profileService.getAllProfile();
	}

	@RequestMapping(value = "/profiles/{profileName}", method = RequestMethod.GET)
	public Profile getProfile(@PathVariable("profileName") String profileName) {
		return profileService.getProfile(profileName);
	}

	@RequestMapping(value = "/profiles", method = RequestMethod.POST)
	public Profile addProfile(@RequestBody Profile profile) {
		return profileService.addProfile(profile);
	}

	@RequestMapping(value = "/profiles", method = RequestMethod.PUT)
	public Profile updateProfile(@RequestBody Profile profile) {
		return profileService.addProfile(profile);
	}

	@RequestMapping(value = "/profiles/{profileName}")
	public void removeProfile(@PathVariable String profileName) {
		profileService.removeProfile(profileName);
	}

}
