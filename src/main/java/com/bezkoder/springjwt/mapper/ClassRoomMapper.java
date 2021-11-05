package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.ClassRoomDTO;
import com.bezkoder.springjwt.dto.CourseDTO;
import com.bezkoder.springjwt.models.ClassRoom;
import com.bezkoder.springjwt.models.Course;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClassRoomMapper {

    ModelMapper modelMapper = new ModelMapper();

    public ClassRoom toEntity(ClassRoomDTO classRoomDTO) {

        return  modelMapper.map(classRoomDTO , ClassRoom.class);
    }

    public ClassRoomDTO toDTO(ClassRoom classRoom) {

        return  modelMapper.map(classRoom , ClassRoomDTO.class);
    }

    public List<ClassRoomDTO> toListDTO(List<ClassRoom> entities){
        return entities.stream().map(
                entity -> this.toDTO(entity)
        ).collect(Collectors.toList());
    }
}
