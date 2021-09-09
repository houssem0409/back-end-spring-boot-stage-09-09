package com.bezkoder.springjwt.repository;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

//@Query(value="SELECT new Student (u.username,u.email)  FROM user u join user_roles ur on u.id = ur.user_id" + "user_roles.role_id =?4"getByStudent();
//
	//Optional<User> findAllByRoles(String roles);

	//Optional<User> findUserByUsername(String name);

	List<User> findUsersByRoles(Role role);





};
