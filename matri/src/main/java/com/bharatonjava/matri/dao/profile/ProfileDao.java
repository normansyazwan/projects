package com.bharatonjava.matri.dao.profile;

import java.util.List;

import com.bharatonjava.matri.domain.Profile;

public interface ProfileDao {

	public int saveProfile(Profile profile);
	public int updateProfile(Profile profile);
	public int deleteProfile(Long profileId);
	public Profile getProfileById(Long profileId);
	public List<Profile> getProfiles();
	public List<Profile> getProfiles(int countOfProfiles);
	
}
