package com.bezkoder.springjwt.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComment;
    private String Message;
    private Date DateComment;
    private String Enum;
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    User user;


}
