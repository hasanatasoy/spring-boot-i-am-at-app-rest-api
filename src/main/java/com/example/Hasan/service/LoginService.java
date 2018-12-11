package com.example.Hasan.service;

import com.example.Hasan.domain.profile.Profile;
import com.example.Hasan.domain.profile.ProfileRepository;
import com.example.Hasan.dto.login.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hasan on 8.12.2018.
 */
@Service
public class LoginService {

    @Autowired
    private ProfileRepository profileRepository;

    public boolean doLogin(LoginDTO loginDTO){
        try {
            Profile profile = profileRepository.findByUsername(loginDTO.getUsername());
            if(profile.getPassword().trim().equals(loginDTO.getPassword().trim()))
                return true;
            else {
                return false;
            }
        }catch (Exception e){return false;}
    }
}
