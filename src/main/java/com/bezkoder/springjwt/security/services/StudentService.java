package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.dto.AdminDTO;
import com.bezkoder.springjwt.dto.StudentDTO;
import com.bezkoder.springjwt.mapper.AdminMapper;
import com.bezkoder.springjwt.mapper.StudentMapper;
import com.bezkoder.springjwt.models.Admin;
import com.bezkoder.springjwt.models.Student;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.AdminRepository;
import com.bezkoder.springjwt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    public List<StudentDTO> getStudents(){
        return studentMapper.toListDTO(studentRepository.findAll());
    }
    public Student getStudentById(Long id){
        return studentRepository.findById(id).get();
    }
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public Student editStudent(StudentDTO student){

        return studentRepository.save(studentMapper.toEntity(student));
    }
    public void deleteStudent( Long id){
        studentRepository.deleteById(id);
    }


}
