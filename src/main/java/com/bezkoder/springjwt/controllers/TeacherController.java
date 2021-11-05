package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.dto.TeacherDTO;
import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Roles;
import com.bezkoder.springjwt.models.Teacher;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.TeacherRepository;
import com.bezkoder.springjwt.security.jwt.JwtUtils;
import com.bezkoder.springjwt.security.services.RoleService;
import com.bezkoder.springjwt.security.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    //http://localhost:8080/system/students

    @GetMapping("teachers")
    public List<TeacherDTO> getTeachers() {
        return teacherService.getTeachers();
    }


    //http://localhost:8080/system/students/id

    @GetMapping("teacher")
    public Teacher getTeacherById(@RequestParam Long id) {
        return teacherService.getTeacherById(id);
    }


    @PostMapping("teacher")
    public Teacher saveTeacher(@RequestBody TeacherDTO request) {
        Set<Roles> roleesT = new HashSet<>();
        Roles roles = new Roles();
        roles.setId(1L);
        roles.setName(ERole.ROLE_TEACHER);
        roleesT.add(roles);
        request.setRoles(roleesT);
        String newpass = encoder.encode(request.getPassword());
        request.setPassword(newpass);
        return teacherService.saveTeacher(request) ;
    }


    @PutMapping("teacherUp")
    public Teacher editTeacher(@RequestBody TeacherDTO request) {

        return teacherService.editTeacher(request);
    }


    @DeleteMapping ("teacherDelete")
    public void deleteTeacher( @RequestParam  Long id){
        teacherService.deleteTeacher(id);
    }
}


