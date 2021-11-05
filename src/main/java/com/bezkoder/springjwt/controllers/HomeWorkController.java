package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dto.HomeWorkDTO;
import com.bezkoder.springjwt.models.HomeWork;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.services.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/homeWork")
public class HomeWorkController {
    @Autowired
    private HomeWorkService homeWorkService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;


    //http://localhost:8080/system/students
    @GetMapping("homeWorks")
    public List<HomeWorkDTO> getHomeWorks(HttpServletResponse httpServletResponse) {
        return homeWorkService.getHomeWorks();
    }

    //http://localhost:8080/system/students/id
    @GetMapping("HomeWork")
    public HomeWork getHomeWorkById(@RequestParam Long id){
        return homeWorkService.getHomeWorkById(id);
    }

    //http://localhost:8080/system/students
    @PostMapping("homeWorks")
    public HomeWork saveHomeWork(@RequestBody HomeWork homeWork){
        return homeWorkService.saveHomeWork(homeWork);
    }

    //http://localhost:8080/system/students
    @PutMapping("homeWorkUp")
    public HomeWork editHomeWork(@RequestBody HomeWorkDTO request) {

        return homeWorkService.editHomeWork(request);
    }

    @DeleteMapping ("homeWorkDelete")
    public void deleteHomeWork( @RequestParam  Long id){
        homeWorkService.deleteHomeWork(id);
    }

    //http://localhost:8080/system/students




}
