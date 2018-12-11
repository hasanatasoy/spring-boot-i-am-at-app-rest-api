package com.example.Hasan.domain.post;

import com.example.Hasan.common.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Hasan on 21.11.2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Post")
@Entity
public class Post extends BaseEntity{

    @Column(nullable = false)
    String username;
    @Column
    String usernameImgUrl;
    @Column
    String postImgUrl;
    @Column(nullable = false)
    double locationLatitude;
    @Column(nullable = false)
    double locationLongtitude;
    @Column
    boolean likeState = false;
}
