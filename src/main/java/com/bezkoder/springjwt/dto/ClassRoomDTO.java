package com.bezkoder.springjwt.dto;

import com.bezkoder.springjwt.models.ClassRoom;
import com.bezkoder.springjwt.models.Course;
import com.bezkoder.springjwt.models.HomeWork;
import com.bezkoder.springjwt.models.Student;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ClassRoomDTO {
    private Long idClassRoom;

    private String RefClassRoom;

    private Set<Student> students = new HashSet<>();

    private Set<Course> courses = new HashSet<>();
}
