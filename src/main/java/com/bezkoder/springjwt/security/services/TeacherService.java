package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.dto.StudentDTO;
import com.bezkoder.springjwt.dto.TeacherDTO;
import com.bezkoder.springjwt.mapper.StudentMapper;
import com.bezkoder.springjwt.mapper.TeacherMapper;
import com.bezkoder.springjwt.models.Student;
import com.bezkoder.springjwt.models.Teacher;
import com.bezkoder.springjwt.repository.StudentRepository;
import com.bezkoder.springjwt.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }
    public List<TeacherDTO> getTeachers(){
        return teacherMapper.toListDTO(teacherRepository.findAll());
    }
    public Teacher getTeacherById(Long id){
        return teacherRepository.findById(id).get();
    }
    public Teacher saveTeacher(TeacherDTO teacher){
        return teacherRepository.save(teacherMapper.toEntity(teacher));
    }
    public Teacher editTeacher(TeacherDTO teacher){

        return teacherRepository.save(teacherMapper.toEntity(teacher));
    }
    public void deleteTeacher( Long id){
        teacherRepository.deleteById(id);
    }
}
