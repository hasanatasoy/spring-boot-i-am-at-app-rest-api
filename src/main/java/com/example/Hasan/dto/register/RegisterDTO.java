package com.example.Hasan.dto.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Hasan on 26.11.2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private String username;
    private String password;
    private String email;
}
