package com.example.Hasan.controller.images;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by Hasan on 9.12.2018.
 */
@RestController
@RequestMapping(value = "/images")
public class ImageController {

    @GetMapping(value = "/{path}")
    public HttpEntity<byte[]> getImage(@PathVariable String path){
        try{
            File pathToFile = new File("D:/deneme/"+path);
            BufferedImage img = ImageIO.read(pathToFile);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", outputStream);
            byte[] image = outputStream.toByteArray();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentLength(image.length);
            return new HttpEntity<byte[]>(image, headers);
        }catch (Exception e){
            return null;
        }
    }

}
