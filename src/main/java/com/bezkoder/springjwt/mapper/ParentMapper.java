package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.ParentDTO;
import com.bezkoder.springjwt.models.Parent;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParentMapper {
    ModelMapper modelMapper = new ModelMapper();

    public Parent toEntity(ParentDTO parentDTO) {

        return  modelMapper.map(parentDTO , Parent.class);
    }

    public ParentDTO toDTO(Parent parent) {

        return  modelMapper.map(parent , ParentDTO.class);
    }

    public List<ParentDTO> toListDTO(List<Parent> entities){
        return entities.stream().map(
                entity -> this.toDTO(entity)
        ).collect(Collectors.toList());
    }
}
