package com.example.Hasan.service;

import com.example.Hasan.Utills.RandomString;
import com.example.Hasan.domain.post.Post;
import com.example.Hasan.domain.post.PostDTO;
import com.example.Hasan.domain.post.PostRepository;
import com.example.Hasan.domain.profile.ProfileRepository;
import javafx.geometry.Pos;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Hasan on 21.11.2018.
 */
@Service
public class PostService {

    @Autowired
    EditProfileService editProfileService;
    @Autowired
    PostRepository postRepository;


    public byte[] stringToImage(String imageString){

        byte[] imageByte;
            try {
                // Burada jpeg png vs kontrolü yapabilirsin unutma burayı yapacaksın
                String[] imageStrings = imageString.split(",");
                imageByte = Base64.decodeBase64(imageStrings[0].getBytes());
                return imageByte;
            }catch (Exception e){
                return null;
            }
    }
    public String saveImageToFile(byte[] imageByte, String imageName){
        String dbImgUrl = "http://192.168.1.100:8080/images/"+imageName+".jpg";
        String imageUrl = "D:/deneme/"+imageName+".jpg";
        try {
            OutputStream stream = new FileOutputStream(imageUrl);
            stream.write(imageByte);
            return dbImgUrl;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete(Post post){
        try {
            postRepository.delete(post);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean save(PostDTO postDTO){
        String imageUrl = saveImageToFile(stringToImage(postDTO.getPostImg()), RandomString.generate(9));
        if(imageUrl != null){
            try{
                postRepository.save(new Post(postDTO.getUsername(),
                        editProfileService.findImageUrlByUsername(postDTO.getUsername()),
                        imageUrl,
                        postDTO.getLatitude(),
                        postDTO.getLongtitude(),false));
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    public List<Post> findAllByLocation(double locationLatitude, double locationLongtitude){
        return postRepository.findPostByLocation(locationLatitude,locationLongtitude);
    }

    public List<Post> findAllByUsername(String username){
        return postRepository.findAllByUsernameOrderByCreatedAtDesc(username);
    }
}
