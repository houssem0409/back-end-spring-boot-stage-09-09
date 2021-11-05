//package com.bezkoder.springjwt.security;
//
//
//import com.bezkoder.springjwt.models.Role;
//import com.bezkoder.springjwt.models.User;
//import com.bezkoder.springjwt.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//import java.util.Set;
//
//
//@Service
//public class MyUserDetails implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//
//
//        final Optional<User> user = userRepository.findByUsername(userName);
//        Set<Role> role=  user.get().getRoles();
//
//
//        if (user == null) {
//            throw new UsernameNotFoundException("This email: '" + userName + "' not found");
//        }
//
//        return org.springframework.security.core.userdetails.User
//                .withUsername(userName)
//                .password(user.get().getPassword())
//                .authorities("ROLE_ADMIN")
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
//                .build();
//
//    }
//
//}
