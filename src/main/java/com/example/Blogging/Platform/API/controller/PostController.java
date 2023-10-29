package com.example.Blogging.Platform.API.controller;

import com.example.Blogging.Platform.API.model.Post;
import com.example.Blogging.Platform.API.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("post")
    public String addPost(@RequestParam String email, @RequestParam String tokenValue, @RequestBody Post newPost){
        return postService.addPost(email,tokenValue,newPost);
    }

    @GetMapping("post/{postId}")
    public Post getPostById(@RequestParam String email, @RequestParam String tokenValue , @PathVariable Integer postId){
        return postService.getPostById(email,tokenValue,postId);
    }

    @PutMapping("post/{postId}/{caption}")
    public String  updatePostById(@RequestParam String email, @RequestParam String tokenValue , @PathVariable Integer postId,String caption){
        return postService.updatePostById(email,tokenValue,postId,caption);
    }

    @DeleteMapping("post/{postId}")
    public String removePostById(@RequestParam String email, @RequestParam String tokenValue , @PathVariable Integer postId){
        return postService.removePostById(email,tokenValue,postId);
    }
}
