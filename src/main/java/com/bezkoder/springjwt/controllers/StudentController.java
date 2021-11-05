package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.dto.AdminDTO;
import com.bezkoder.springjwt.dto.StudentDTO;
import com.bezkoder.springjwt.models.Admin;
import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Roles;
import com.bezkoder.springjwt.models.Student;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.StudentRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.jwt.JwtUtils;
import com.bezkoder.springjwt.security.services.AdminService;
import com.bezkoder.springjwt.security.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    //http://localhost:8080/system/students
   // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("students")
    public List<StudentDTO> getStudents(HttpServletResponse httpServletResponse) {
        return studentService.getStudents();
    }

    //http://localhost:8080/system/students
    @PostMapping("students")
    public Student saveUser(@RequestBody Student student){
        Set<Roles> rolees = new HashSet<>();
        Roles roles = new Roles();
        roles.setId(4L);
        roles.setName(ERole.ROLE_STUDENT);
        rolees.add(roles);
        student.setRoles(rolees);
        String newpass = encoder.encode(student.getPassword());
        student.setPassword(newpass);
        return studentService.saveStudent(student);
    }
    //http://localhost:8080/system/students/id
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("student")
    public Student getStudentById(@RequestParam Long id) {
        return studentService.getStudentById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("studentUp")
    public Student editStudent(@RequestBody StudentDTO request) {

        return studentService.editStudent(request);
    }


    @DeleteMapping ("studentDelete")
    public void deleteStudent( @RequestParam  Long id){
        studentService.deleteStudent(id);
    }
}
