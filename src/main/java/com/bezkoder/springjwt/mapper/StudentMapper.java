package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.AdminDTO;
import com.bezkoder.springjwt.dto.StudentDTO;
import com.bezkoder.springjwt.models.Admin;
import com.bezkoder.springjwt.models.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class StudentMapper {

    ModelMapper modelMapper = new ModelMapper();

    public Student toEntity(StudentDTO userDTO) {

        return  modelMapper.map(userDTO , Student.class);
    }

    public StudentDTO toDTO(Student user) {

        return  modelMapper.map(user , StudentDTO.class);
    }

    public List<StudentDTO> toListDTO(List<Student> entities){
        return entities.stream().map(
                entity -> this.toDTO(entity)
        ).collect(Collectors.toList());
    }
}
