package com.bezkoder.springjwt.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    public class ClassRoom {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idClassRoom;
        private String RefClassRoom;
        @OneToMany(mappedBy = "classRoom")
        List<Student> students;

        @ManyToMany
        @JoinTable(name = "ClassRoom_Course",
                joinColumns = @JoinColumn(name = "classRoom_id"),
                inverseJoinColumns = @JoinColumn(name = "course_id"))
        List<Course> courses;

    }


