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
public class HomeWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHomeWork;
    private Date dateStart;
    private Date dateEnd;
    @ManyToOne
    Course course;
}
