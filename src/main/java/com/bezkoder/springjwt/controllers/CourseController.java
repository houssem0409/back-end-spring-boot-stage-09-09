package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dto.CourseDTO;
import com.bezkoder.springjwt.dto.StudentDTO;
import com.bezkoder.springjwt.models.Course;
import com.bezkoder.springjwt.models.Student;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.services.CourseService;
import com.bezkoder.springjwt.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;


    //http://localhost:8080/system/students
    @GetMapping("courses")
    public List<CourseDTO> getStudents(HttpServletResponse httpServletResponse) {
        return courseService.getCourses();
    }

    //http://localhost:8080/system/students/id
    @GetMapping("Course")
    public Course getCourseById(@RequestParam Long id){
        return courseService.getCourseById(id);
    }

    //http://localhost:8080/system/students
    @PostMapping("courses")
    public Course saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    //http://localhost:8080/system/students
    @PutMapping("courseUp")
    public Course editStudent(@RequestBody CourseDTO request) {

        return courseService.editCourse(request);
    }

    @DeleteMapping ("courseDelete")
    public void deleteCourse( @RequestParam  Long id){
        courseService.deleteCourse(id);
    }

    //http://localhost:8080/system/students




}
