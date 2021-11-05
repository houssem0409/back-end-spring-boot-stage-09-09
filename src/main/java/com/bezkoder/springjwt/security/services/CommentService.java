package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.dto.CommentDTO;
import com.bezkoder.springjwt.dto.CourseDTO;
import com.bezkoder.springjwt.mapper.CommentMapper;
import com.bezkoder.springjwt.mapper.CourseMapper;
import com.bezkoder.springjwt.models.Comment;
import com.bezkoder.springjwt.models.Course;
import com.bezkoder.springjwt.repository.CommentRepository;
import com.bezkoder.springjwt.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    @Autowired
    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }
    public List<CommentDTO> getComments(){
        return commentMapper.toListDTO(commentRepository.findAll());
    }
    public Comment getCommentById(Long id){
        return commentRepository.findById(id).get();
    }
    public Comment saveComment(Comment comment){
        return commentRepository.save(comment);
    }
    public Comment editComment(CommentDTO comment){

        return commentRepository.save(commentMapper.toEntity(comment));
    }
    public void deleteComment( Long id){
        commentRepository.deleteById(id);
    }


}
