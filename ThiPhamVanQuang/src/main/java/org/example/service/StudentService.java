package org.example.service;

import org.example.dto.StudentDTO;
import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(student -> {
            StudentDTO dto = new StudentDTO();
            dto.setStudentId(student.getStudentId());
            dto.setStudentCode(student.getStudentCode());
            dto.setFullName(student.getFullName());
            dto.setAddress(student.getAddress());
            return dto;
        }).collect(Collectors.toList());
    }
    public void addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudentCode(studentDTO.getStudentCode());
        student.setFullName(studentDTO.getFullName());
        student.setAddress(studentDTO.getAddress());
        studentRepository.save(student);
    }
}
