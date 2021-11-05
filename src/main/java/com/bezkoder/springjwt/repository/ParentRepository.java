package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParentRepository extends JpaRepository<Parent , Long> {
}
