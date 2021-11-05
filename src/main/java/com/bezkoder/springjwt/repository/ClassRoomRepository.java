package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository  extends JpaRepository<ClassRoom , Long> {
}
