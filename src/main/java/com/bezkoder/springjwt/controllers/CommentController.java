package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.dto.CommentDTO;
import com.bezkoder.springjwt.models.Comment;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;


    //http://localhost:8080/system/students
    @GetMapping("comments")
    public List<CommentDTO> getComments(HttpServletResponse httpServletResponse) {
        return commentService.getComments();
    }

    //http://localhost:8080/system/students/id
    @GetMapping("Comment")
    public Comment getCommentById(@RequestParam Long id){
        return commentService.getCommentById(id);
    }

    //http://localhost:8080/system/students
    @PostMapping("comments")
    public Comment saveComment(@RequestBody Comment comment){
        return commentService.saveComment(comment);
    }

    //http://localhost:8080/system/students
    @PutMapping("commentUp")
    public Comment editComment(@RequestBody CommentDTO request) {

        return commentService.editComment(request);
    }

    @DeleteMapping ("commentDelete")
    public void deleteComment( @RequestParam  Long id){
        commentService.deleteComment(id);
    }

    //http://localhost:8080/system/students




}
