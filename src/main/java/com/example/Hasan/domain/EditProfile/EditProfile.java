package com.example.Hasan.domain.EditProfile;

import com.example.Hasan.common.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Hasan on 26.11.2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "editProfile")
@Entity
public class EditProfile{

    public EditProfile(String username, String email){
        this.username = username;
        this.email = email;
    }
    @Id
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column
    private String usernameImgUrl = "http://192.168.1.100:8080/images/default.jpg";
    @Column
    private String name;
    @Column
    private String information;
    @Column
    private String bio;
    @Column
    private String telNo;
    @Column
    private boolean gender;
}
