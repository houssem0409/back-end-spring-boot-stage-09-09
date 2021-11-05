package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
	Optional<Roles> findByName(ERole name);
}
