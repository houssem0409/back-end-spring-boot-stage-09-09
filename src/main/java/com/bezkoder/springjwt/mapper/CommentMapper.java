package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.CommentDTO;
import com.bezkoder.springjwt.models.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentMapper {

    ModelMapper modelMapper = new ModelMapper();

    public Comment toEntity(CommentDTO commentDTO) {

        return  modelMapper.map(commentDTO , Comment.class);
    }

    public CommentDTO toDTO(Comment comment) {

        return  modelMapper.map(comment, CommentDTO.class);
    }

    public List<CommentDTO> toListDTO(List<Comment> entities){
        return entities.stream().map(
                entity -> this.toDTO(entity)
        ).collect(Collectors.toList());
    }
}
