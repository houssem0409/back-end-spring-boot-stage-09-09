package com.bezkoder.springjwt.dto;

import com.bezkoder.springjwt.models.ClassRoom;
import com.bezkoder.springjwt.models.HomeWork;
import com.bezkoder.springjwt.models.Roles;
import com.bezkoder.springjwt.models.Teacher;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CourseDTO {
    private Long idCourse;

    private String Name;

    private Set<Teacher> teachers = new HashSet<>();

    private Set<HomeWork> homeWorks = new HashSet<>();

    private Set<ClassRoom> classRooms = new HashSet<>();

}
