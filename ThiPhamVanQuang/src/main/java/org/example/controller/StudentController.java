package org.example.controller;

import ch.qos.logback.core.model.Model;
import org.example.dto.StudentDTO;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @PostMapping("/students")
    public String addStudent(@RequestParam String studentCode, @RequestParam String fullName, @RequestParam String address) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentCode(studentCode);
        studentDTO.setFullName(fullName);
        studentDTO.setAddress(address);
        studentService.addStudent(studentDTO);
        return "redirect:/students";
    }
}
