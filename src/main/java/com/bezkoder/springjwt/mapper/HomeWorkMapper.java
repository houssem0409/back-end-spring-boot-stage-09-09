package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.HomeWorkDTO;
import com.bezkoder.springjwt.models.HomeWork;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HomeWorkMapper {
    ModelMapper modelMapper = new ModelMapper();

    public HomeWork toEntity(HomeWorkDTO homeWorkDTO) {

        return  modelMapper.map(homeWorkDTO , HomeWork.class);
    }

    public HomeWorkDTO toDTO(HomeWork homeWork) {

        return  modelMapper.map(homeWork , HomeWorkDTO.class);
    }

    public List<HomeWorkDTO> toListDTO(List<HomeWork> entities){
        return entities.stream().map(
                entity -> this.toDTO(entity)
        ).collect(Collectors.toList());
    }
}
