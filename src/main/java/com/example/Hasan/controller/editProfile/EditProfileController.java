package com.example.Hasan.controller.editProfile;

import com.example.Hasan.domain.EditProfile.EditProfile;
import com.example.Hasan.service.EditProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hasan on 8.12.2018.
 */
@RequestMapping(value = "/editprofile")
@RestController
public class EditProfileController {

    @Autowired
    EditProfileService editProfileService;


    @GetMapping(value = "/{username}")
    public EditProfile findByUsername(@PathVariable String username){
        return editProfileService.findByUsername(username);
    }

    @PostMapping(value = "/update")
    public boolean updateEditProfile(@RequestBody EditProfile editProfile){
        return editProfileService.save(editProfile);
    }
}
