package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.dto.CourseDTO;
import com.bezkoder.springjwt.mapper.CourseMapper;
import com.bezkoder.springjwt.models.Course;
import com.bezkoder.springjwt.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    @Autowired
    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }
    public List<CourseDTO> getCourses(){
        return courseMapper.toListDTO(courseRepository.findAll());
    }
    public Course getCourseById(Long id){
        return courseRepository.findById(id).get();
    }
    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }
    public Course editCourse(CourseDTO course){

        return courseRepository.save(courseMapper.toEntity(course));
    }
    public void deleteCourse( Long id){
        courseRepository.deleteById(id);
    }


}
