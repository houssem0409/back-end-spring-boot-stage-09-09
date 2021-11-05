package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course , Long> {
}
