package com.adem.messenger.service;

import java.util.List;

import com.adem.messenger.entities.Profile;

public interface ProfileService {
	
	public List<Profile> getAllProfile();

	public Profile getProfile(String profileName);

	public Profile addProfile(Profile profile);

	public Profile updateProfile(Profile profile);

	public void removeProfile(String profileName);

}
