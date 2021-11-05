package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.dto.RoleDTO;
import com.bezkoder.springjwt.mapper.RoleMapper;
import com.bezkoder.springjwt.models.Roles;
import com.bezkoder.springjwt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    @Autowired
    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }
    public List<RoleDTO> getRoles(){
        return roleMapper.toListDTO(roleRepository.findAll());
    }
    public Roles getRoleById(Long id){
        return roleRepository.findById(id).get();
    }
    public Roles saveRole(Roles roles){
        return roleRepository.save(roles);
    }
    public Roles editRole(RoleDTO role){

        return roleRepository.save(roleMapper.toEntity(role));
    }
    public void deleteRole( Long id){
        roleRepository.deleteById(id);
    }

}
