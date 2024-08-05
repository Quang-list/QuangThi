package org.example.controller;

import ch.qos.logback.core.model.Model;
import org.example.dto.SubjectDTO;
import org.example.service.SubjectService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public String getAllSubjects (Model model) {
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "subjects";
    }

    @PostMapping("/subjects")
    public String addSubject(@RequestParam String subjectCode, @RequestParam String subjectName, @RequestParam int credit) {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setSubjectCode(subjectCode);
        subjectDTO.setSubjectName(subjectName);
        subjectDTO.setCredit(credit);
        subjectService.addSubject(subjectDTO);
        return "redirect:/subjects";
    }
}
