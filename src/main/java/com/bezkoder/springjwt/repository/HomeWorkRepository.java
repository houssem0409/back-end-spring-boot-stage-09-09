package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeWorkRepository extends JpaRepository<HomeWork , Long> {
}
