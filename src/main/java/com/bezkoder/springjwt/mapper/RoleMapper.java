package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.RoleDTO;
import com.bezkoder.springjwt.models.Roles;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapper {
    ModelMapper modelMapper = new ModelMapper();

    public Roles toEntity(RoleDTO roleDTO) {

        return  modelMapper.map(roleDTO , Roles.class);
    }

    public RoleDTO toDTO(Roles roles) {

        return  modelMapper.map(roles, RoleDTO.class);
    }
    public List<RoleDTO> toListDTO(List<Roles> entities){
        return entities.stream().map(
                entity -> this.toDTO(entity)
        ).collect(Collectors.toList());
    }

}
