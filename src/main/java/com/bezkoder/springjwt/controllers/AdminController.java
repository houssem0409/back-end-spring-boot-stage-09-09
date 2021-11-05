package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dto.AdminDTO;
import com.bezkoder.springjwt.models.Admin;
import com.bezkoder.springjwt.payload.request.UpdateRequest;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.jwt.JwtUtils;
import com.bezkoder.springjwt.security.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository adminRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


    //http://localhost:8080/system/students
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("admins")
    public List<AdminDTO> getUsers() {
        return adminService.getAdmins();
    }


    //http://localhost:8080/system/students/id
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("admin")
    public Admin getAdminById(@RequestParam Long id) {
        return adminService.getAdminById(id);
    }

    /*
            //http://localhost:8080/system/students
            @PreAuthorize("hasRole('ADMIN')")
            @PostMapping("users")
            public User saveUser(@RequestBody User user){
                return userService.saveUser(user);
            }
    */
    //http://localhost:8080/system/students
    //@PreAuthorize("hasRole('STUDENT')")
    @PutMapping("adminUp")
    public Admin editAdmin(@RequestBody AdminDTO request) {

        return adminService.editAdmin(request);
    }
        /*
        @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping ("users")
        public void deleteUser( @RequestParam  Long id){
            userService.deleteUser(id);
        }

        //http://localhost:8080/system/students
        @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
        @GetMapping("students")
        public List<User> getStudents(){

            return userService.getStudents();
        }


    }

 */

}
