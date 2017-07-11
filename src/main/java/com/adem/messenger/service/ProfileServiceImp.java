package com.adem.messenger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adem.messenger.dao.ProfileRepository;
import com.adem.messenger.entities.Profile;

@Service
public class ProfileServiceImp implements ProfileService {

	@Autowired
	private ProfileRepository profileRepo;

	@Override
	public List<Profile> getAllProfile() {
		return profileRepo.findAll();
	}

	@Override
	public Profile getProfile(String profileName) {
		return profileRepo.getOne(profileName);
	}

	@Override
	public Profile addProfile(Profile profile) {
		return profileRepo.save(profile);
	}

	@Override
	public Profile updateProfile(Profile profile) {
		return profileRepo.save(profile);
	}

	@Override
	public void removeProfile(String profileName) {
		profileRepo.delete(profileName);

	}

}
