package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.UserDTO;
import com.bezkoder.springjwt.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    ModelMapper modelMapper = new ModelMapper();

    public User toEntity(UserDTO userDTO) {

      return  modelMapper.map(userDTO , User.class);
    }

    public UserDTO toDTO(User user) {

      return  modelMapper.map(user , UserDTO.class);
    }

}
