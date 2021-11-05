package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dto.ClassRoomDTO;
import com.bezkoder.springjwt.dto.CourseDTO;
import com.bezkoder.springjwt.models.ClassRoom;
import com.bezkoder.springjwt.models.Course;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.services.ClassRoomService;
import com.bezkoder.springjwt.security.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/classRoom")
public class ClassRoomController {
    @Autowired
    private ClassRoomService classRoomService;
    @Autowired
    AuthenticationManager authenticationManager;


    //http://localhost:8080/system/students
    @GetMapping("classRooms")
    public List<ClassRoomDTO> getClassRooms(HttpServletResponse httpServletResponse) {
        return classRoomService.getClassRooms();
    }

    //http://localhost:8080/system/students/id
    @GetMapping("classRoom")
    public ClassRoom getCourseById(@RequestParam Long id){
        return classRoomService.getClassRoomById(id);
    }

    //http://localhost:8080/system/students
    @PostMapping("classRooms")
    public ClassRoom saveClassRoom(@RequestBody ClassRoom classRoom){
        return classRoomService.saveClassRoom(classRoom);
    }

    //http://localhost:8080/system/students
    @PutMapping("classRoomUp")
    public ClassRoom editClassRoom(@RequestBody ClassRoomDTO request) {

        return classRoomService.editClassRoom(request);
    }

    @DeleteMapping ("classRoomDelete")
    public void deleteClassRoom( @RequestParam  Long id){
        classRoomService.deleteClassRoom(id);
    }

    //http://localhost:8080/system/students




}
