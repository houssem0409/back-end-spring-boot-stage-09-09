package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.TeacherDTO;
import com.bezkoder.springjwt.models.Teacher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeacherMapper {


    ModelMapper modelMapper = new ModelMapper();

    public Teacher toEntity(TeacherDTO teacherDTO) {

        return  modelMapper.map(teacherDTO , Teacher.class);
    }

    public TeacherDTO toDTO(Teacher teacher) {

        return  modelMapper.map(teacher , TeacherDTO.class);
    }

    public List<TeacherDTO> toListDTO(List<Teacher> entities){
        return entities.stream().map(
                entity -> this.toDTO(entity)
        ).collect(Collectors.toList());
    }


}
