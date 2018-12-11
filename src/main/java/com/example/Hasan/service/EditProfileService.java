package com.example.Hasan.service;

import com.example.Hasan.domain.EditProfile.EditProfile;
import com.example.Hasan.domain.EditProfile.EditProfileRepository;
import com.example.Hasan.domain.profile.Profile;
import com.example.Hasan.domain.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hasan on 8.12.2018.
 */
@Service
public class EditProfileService {

    @Autowired
    EditProfileRepository editProfileRepository;
    @Autowired
    ProfileRepository profileRepository;


    public String findImageUrlByUsername(String username){
        return editProfileRepository.findProfileUrlByUsername(username);
    }

    public EditProfile findByUsername(String username){
        return editProfileRepository.findByUsername(username);
    }

    public boolean save(EditProfile editProfile){
        try{
            editProfileRepository.save(editProfile);
            profileRepository.save(new Profile(editProfile.getUsername(),
                    editProfile.getBio(),editProfile.getInformation(),editProfile.getName()));
            return true;
        }catch (Exception e){
            System.out.println("Edit Profile update error : "+e.getMessage());
            return false;
        }
    }
}
