package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.CourseDTO;
import com.bezkoder.springjwt.models.Course;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CourseMapper {

    ModelMapper modelMapper = new ModelMapper();

    public Course toEntity(CourseDTO courseDTO) {

        return  modelMapper.map(courseDTO , Course.class);
    }

    public CourseDTO toDTO(Course course) {

        return  modelMapper.map(course , CourseDTO.class);
    }

    public List<CourseDTO> toListDTO(List<Course> entities){
        return entities.stream().map(
                entity -> this.toDTO(entity)
        ).collect(Collectors.toList());
    }
}
