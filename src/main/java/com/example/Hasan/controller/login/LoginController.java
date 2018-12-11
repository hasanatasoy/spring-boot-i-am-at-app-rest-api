package com.example.Hasan.controller.login;

import com.example.Hasan.dto.login.LoginDTO;
import com.example.Hasan.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hasan on 8.12.2018.
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;


    @PostMapping(value = "/check")
    public boolean doLogin(@RequestBody LoginDTO loginDTO){
        return loginService.doLogin(loginDTO);
    }
}
