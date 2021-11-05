package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.dto.HomeWorkDTO;
import com.bezkoder.springjwt.mapper.HomeWorkMapper;
import com.bezkoder.springjwt.models.HomeWork;
import com.bezkoder.springjwt.repository.HomeWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeWorkService {
    private final HomeWorkRepository homeWorkRepository;
    private final HomeWorkMapper homeWorkMapper;
    @Autowired
    public HomeWorkService(HomeWorkRepository homeWorkRepository, HomeWorkMapper homeWorkMapper) {
        this.homeWorkRepository = homeWorkRepository;
        this.homeWorkMapper = homeWorkMapper;
    }
    public List<HomeWorkDTO> getHomeWorks(){
        return homeWorkMapper.toListDTO(homeWorkRepository.findAll());
    }
    public HomeWork getHomeWorkById(Long id){
        return homeWorkRepository.findById(id).get();
    }
    public HomeWork saveHomeWork(HomeWork homeWork){
        return homeWorkRepository.save(homeWork);
    }
    public HomeWork editHomeWork(HomeWorkDTO homeWork){

        return homeWorkRepository.save(homeWorkMapper.toEntity(homeWork));
    }
    public void deleteHomeWork( Long id){
        homeWorkRepository.deleteById(id);
    }


}
