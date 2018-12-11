package com.example.Hasan.controller.profile;

import com.example.Hasan.domain.profile.Profile;
import com.example.Hasan.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hasan on 26.11.2018.
 */
@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping(value = "/all")
    public List<Profile> getAllProfile(){
        return profileService.getAllProfile();
    }

    @GetMapping(value = "/{username}")
    public Profile findByUsername(@PathVariable String username){
        return profileService.findByUsername(username);
    }

}
