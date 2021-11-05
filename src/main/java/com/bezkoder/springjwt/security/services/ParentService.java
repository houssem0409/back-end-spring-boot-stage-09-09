package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.dto.ParentDTO;
import com.bezkoder.springjwt.mapper.ParentMapper;
import com.bezkoder.springjwt.models.Parent;
import com.bezkoder.springjwt.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    private final ParentRepository parentRepository;
    private final ParentMapper parentMapper;
    @Autowired
    public ParentService(ParentRepository parentRepository, ParentMapper parentMapper) {
        this.parentRepository = parentRepository;
        this.parentMapper = parentMapper;
    }
    public List<ParentDTO> getParents(){
        return parentMapper.toListDTO(parentRepository.findAll());
    }
    public Parent getParentById(Long id){
        return parentRepository.findById(id).get();
    }
    public Parent saveParent(Parent parent){
        return parentRepository.save(parent);
    }
    public Parent editParent(ParentDTO parent){

        return parentRepository.save(parentMapper.toEntity(parent));
    }
    public void deleteParent( Long id){
        parentRepository.deleteById(id);
    }


}
