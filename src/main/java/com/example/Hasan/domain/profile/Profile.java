package com.example.Hasan.domain.profile;

import com.example.Hasan.common.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * Created by Hasan on 26.11.2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profile  {

    public Profile(String username,String bio,String description,String name){
        this.username = username;
        this.bio = bio;
        this.description = description;
        this.name = name;
    }
    public Profile(String username, String password,int photoCount, int likeCount){
        this.username = username;
        this.password = password;
        this.photoCount = photoCount;
        this.likeCount = likeCount;
    }

    @Id
    @Column(nullable = false)
    private String username;
    @Column
    private String password;
    @Column
    private int photoCount;
    @Column
    private int likeCount;
    @Column
    private String usernamePpUrl = "http://192.168.1.100:8080/images/default.jpg";
    @Column
    private String name = "İsim Soyisim";
    @Column
    private String description = "Açıklama";
    @Column
    private String bio = "Biyografinizi Yazınız";

}
