package com.example.Hasan.controller.post;

import com.example.Hasan.domain.post.Post;
import com.example.Hasan.domain.post.PostDTO;
import com.example.Hasan.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hasan on 21.11.2018.
 */
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;


    @PostMapping(value = "/save")
    public boolean savePost(@RequestBody PostDTO postDTO){
       return postService.save(postDTO);
    }

    @GetMapping(value = "/get/{latitude}/{longtitude}")
    public List<Post> findAllByLocation (@PathVariable double latitude, @PathVariable double longtitude){
        return postService.findAllByLocation(latitude,longtitude);
    }

    @GetMapping(value = "/all/{username}")
    public List<Post> findAllByUsername(@PathVariable String username){
        return postService.findAllByUsername(username);
    }

    @PostMapping(value = "/delete")
    public boolean deletePost(@RequestBody Post post){
        return postService.delete(post);
    }
}
