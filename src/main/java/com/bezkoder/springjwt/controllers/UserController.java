package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.jwt.JwtUtils;
import com.bezkoder.springjwt.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;




    //http://localhost:8080/system/students
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("users")
    public List<User> getUsers(){
        return userService.getUsers();
    }


    //http://localhost:8080/system/students/id
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("user")
    public User getUserById(@RequestParam Long id){
        return userService.getUserById(id);
    }

    //http://localhost:8080/system/students
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("users")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    //http://localhost:8080/system/students
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("usersUp")
    public User editUser(@RequestBody User user, @RequestParam  Long id){
        user.setId(id);
        return userService.editUser(user);
    }
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
