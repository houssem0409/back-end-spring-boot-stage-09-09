package com.bezkoder.springjwt.dto;

import com.bezkoder.springjwt.models.EComment;
import lombok.Data;

import java.util.Date;
@Data
public class CommentDTO {
    private Long idComment;
    private String Message;
    private EComment name;
    private Date dateComment;
    private Long UserId;

}
