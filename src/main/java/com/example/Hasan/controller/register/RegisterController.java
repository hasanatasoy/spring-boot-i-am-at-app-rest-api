package com.example.Hasan.controller.register;

import com.example.Hasan.dto.register.RegisterDTO;
import com.example.Hasan.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hasan on 26.11.2018.
 */
@RestController
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping(value = "/add")
    public Boolean createProfile(@RequestBody RegisterDTO registerDTO){
        return registerService.createNewProfile(registerDTO);
    }
}
