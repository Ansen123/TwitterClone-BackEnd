package com.nestdigital.twiter.Controller;

import com.nestdigital.twiter.Dao.PostDao;
import com.nestdigital.twiter.Model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addPost",consumes = "application/json",produces = "application/json")
    public String AddPosts(@RequestBody PostModel post)
    {
        DateTimeFormatter dt= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now =LocalDateTime.now();
        String currentdate= String.valueOf(dt.format(now));
        post.setPostDate(currentdate);
      System.out.println(post.toString());
      dao.save(post);

        return "{status:'Success'}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<String>viewpost(){
        return (List<String>) dao.ViewAllPosts();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/single")
    List<PostModel> viewSingle(@RequestBody PostModel post){
        return (List<PostModel>) dao.ViewSingle(post.getUserId());
    }
}
