package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.dto.AdminDTO;
import com.bezkoder.springjwt.mapper.AdminMapper;
import com.bezkoder.springjwt.models.Admin;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    @Autowired
    public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }
    public List<AdminDTO> getAdmins(){
        return adminMapper.toListDTO(adminRepository.findAll());
    }
    public Admin getAdminById(Long id){
        return adminRepository.findById(id).get();
    }
    public User saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }
    public Admin editAdmin(AdminDTO admin){

        return adminRepository.save(adminMapper.toEntity(admin));
    }
    public void deleteAdmin( Long id){
        adminRepository.deleteById(id);
    }



}
