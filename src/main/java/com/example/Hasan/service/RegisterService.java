package com.example.Hasan.service;

import com.example.Hasan.domain.EditProfile.EditProfile;
import com.example.Hasan.domain.EditProfile.EditProfileRepository;
import com.example.Hasan.domain.profile.ProfileRepository;
import com.example.Hasan.domain.profile.Profile;
import com.example.Hasan.dto.register.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hasan on 26.11.2018.
 */
@Service
public class RegisterService {

    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    EditProfileRepository editProfileRepository;

    public boolean createNewProfile(RegisterDTO registerDTO){
        try {
            profileRepository.save(new Profile(registerDTO.getUsername(),registerDTO.getPassword(),
                    0,0));
            editProfileRepository.save(new EditProfile(registerDTO.getUsername(),registerDTO.getEmail()));
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
