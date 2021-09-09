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
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvaluation;
    private float Note;
    private String Feedback;
    private Date DateEvaluation;
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    Teacher teacher;
    @ManyToOne()
    Parent parent;



}
