package org.example.service;

import org.example.dto.SubjectDTO;
import org.example.entity.Subject;
import org.example.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    // Phương thức để thêm môn học
    public void addSubject(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setSubjectCode(subjectDTO.getSubjectCode());
        subject.setSubjectName(subjectDTO.getSubjectName());
        subject.setCredit(subjectDTO.getCredit());
        subjectRepository.save(subject);
    }

    // Phương thức để lấy tất cả các môn học
    public List<SubjectDTO> getAllSubjects() {
        return subjectRepository.findAll().stream().map(subject -> {
            SubjectDTO dto = new SubjectDTO();
            dto.setSubjectId(subject.getSubjectId());
            dto.setSubjectCode(subject.getSubjectCode());
            dto.setSubjectName(subject.getSubjectName());
            dto.setCredit(subject.getCredit());
            return dto;
        }).collect(Collectors.toList());
    }

    // Phương thức để lấy thông tin môn học theo ID
    public SubjectDTO getSubjectById(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).orElse(null);
        if (subject != null) {
            SubjectDTO dto = new SubjectDTO();
            dto.setSubjectId(subject.getSubjectId());
            dto.setSubjectCode(subject.getSubjectCode());
            dto.setSubjectName(subject.getSubjectName());
            dto.setCredit(subject.getCredit());
            return dto;
        }
        return null;
    }
}
