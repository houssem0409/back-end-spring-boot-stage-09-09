package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.AdminDTO;
import com.bezkoder.springjwt.dto.UserDTO;
import com.bezkoder.springjwt.models.Admin;
import com.bezkoder.springjwt.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminMapper {

    ModelMapper modelMapper = new ModelMapper();

    public Admin toEntity(AdminDTO userDTO) {

        return  modelMapper.map(userDTO , Admin.class);
    }

    public AdminDTO toDTO(Admin user) {

        return  modelMapper.map(user , AdminDTO.class);
    }

    public List<AdminDTO> toListDTO(List<Admin> entities){
        return entities.stream().map(
                entity -> this.toDTO(entity)
        ).collect(Collectors.toList());
    }
}
