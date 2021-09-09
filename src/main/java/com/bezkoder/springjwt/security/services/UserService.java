package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User editUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser( Long id){
        userRepository.deleteById(id);
    }


    public List<User> getStudents() {
        Role role = new Role(1L, ERole.ROLE_ADMIN);
        return  userRepository.findUsersByRoles(role);
    }
}
