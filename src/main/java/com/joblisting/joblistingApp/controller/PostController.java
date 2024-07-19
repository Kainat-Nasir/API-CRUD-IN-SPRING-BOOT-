package com.joblisting.joblistingApp.controller;

import com.joblisting.joblistingApp.PostRepository;
import com.joblisting.joblistingApp.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    PostRepository repo;

    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

   @GetMapping("/posts")
    public List<Post> getAllPosts(){
         return repo.findAll();

    }
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
       return repo.save(post);
    }
    @PutMapping("/posts")
    public Post updatePost(@RequestBody Post post) {
        Optional<Post> update = repo.findById(post.getId());

        if(post.getId().isEmpty() || update.isEmpty()){
            System.out.println("No record found!");
            return null;
        }

        return repo.save(post);
    }
    @DeleteMapping("/posts/{id}")
    public Post deletePost(@PathVariable String id) {
        Optional<Post> post = repo.findById(id);

        if (post.isEmpty()) {
            System.out.println("No record found!");
        }

        repo.deleteById(id);
        System.out.println("Deleted Successfully !");
        return null;
    }
}
