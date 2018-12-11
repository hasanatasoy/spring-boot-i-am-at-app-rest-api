package com.example.Hasan.service;

import com.example.Hasan.domain.profile.Profile;
import com.example.Hasan.domain.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hasan on 26.11.2018.
 */
@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public List<Profile> getAllProfile() {
        return profileRepository.findAll();
    }

    public Profile findByUsername(String username) {

        return profileRepository.findByUsername(username);
    }


}
