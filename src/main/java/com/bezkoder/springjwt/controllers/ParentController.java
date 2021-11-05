package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dto.ParentDTO;
import com.bezkoder.springjwt.dto.StudentDTO;
import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Parent;
import com.bezkoder.springjwt.models.Roles;
import com.bezkoder.springjwt.models.Student;
import com.bezkoder.springjwt.repository.ParentRepository;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.StudentRepository;
import com.bezkoder.springjwt.security.jwt.JwtUtils;
import com.bezkoder.springjwt.security.services.ParentService;
import com.bezkoder.springjwt.security.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.PropertyEntry;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/parent/")
public class ParentController {
    @Autowired
    private ParentService parentService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    //http://localhost:8080/system/students
    // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("parents")
    public List<ParentDTO> getParents(HttpServletResponse httpServletResponse) {
        return parentService.getParents();
    }

    //http://localhost:8080/system/students
    @PostMapping("parents")
    public Parent savePrent(@RequestBody Parent parent){
        Set<Roles> rolees = new HashSet<>();
        Roles roles = new Roles();
        roles.setId(2L);
        roles.setName(ERole.ROLE_PARENT);
        rolees.add(roles);
        parent.setRoles(rolees);
        String newpass = encoder.encode(parent.getPassword());
        parent.setPassword(newpass);
        return parentService.saveParent(parent);
    }
    //http://localhost:8080/system/students/id
    //@PreAuthorize("hasRole('STUDENT') or hasRole('PARENT') or hasRole('ADMIN')")
    @GetMapping("parent")
    public Parent getParentById(@RequestParam Long id) {
        return parentService.getParentById(id);
    }

   // @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("parentUp")
    public Parent editParent(@RequestBody ParentDTO request) {

        return parentService.editParent(request);
    }


    @DeleteMapping ("parentDelete")
    public void deleteParent( @RequestParam  Long id){
        parentService.deleteParent(id);
    }
}
