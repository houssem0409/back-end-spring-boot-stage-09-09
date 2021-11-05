package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.dto.ClassRoomDTO;
import com.bezkoder.springjwt.dto.CourseDTO;
import com.bezkoder.springjwt.mapper.ClassRoomMapper;
import com.bezkoder.springjwt.mapper.CourseMapper;
import com.bezkoder.springjwt.models.ClassRoom;
import com.bezkoder.springjwt.models.Course;
import com.bezkoder.springjwt.repository.ClassRoomRepository;
import com.bezkoder.springjwt.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService {
    private final ClassRoomRepository classRoomRepository;
    private final ClassRoomMapper classRoomMapper;
    @Autowired
    public ClassRoomService(ClassRoomRepository classRoomRepository, ClassRoomMapper classRoomMapper) {
        this.classRoomRepository = classRoomRepository;
        this.classRoomMapper = classRoomMapper;
    }
    public List<ClassRoomDTO> getClassRooms(){
        return classRoomMapper.toListDTO(classRoomRepository.findAll());
    }
    public ClassRoom getClassRoomById(Long id){
        return classRoomRepository.findById(id).get();
    }
    public ClassRoom saveClassRoom(ClassRoom classRoom){
        return classRoomRepository.save(classRoom);
    }
    public ClassRoom editClassRoom(ClassRoomDTO classRoomDTO){

        return classRoomRepository.save(classRoomMapper.toEntity(classRoomDTO));
    }
    public void deleteClassRoom( Long id){
        classRoomRepository.deleteById(id);
    }


}
