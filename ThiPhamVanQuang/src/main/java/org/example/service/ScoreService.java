package org.example.service;

import org.example.dto.ScoreDTO;
import org.example.entity.Score;
import org.example.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    // Phương thức để tính toán điểm cuối cùng
    public double calculateFinalScore(double score1, double score2) {
        return 0.3 * score1 + 0.7 * score2;
    }

    // Phương thức để thêm điểm
    public void addScore(ScoreDTO scoreDTO) {
        Score score = new Score();
        score.setStudentId(scoreDTO.getStudentId());
        score.setSubjectId(scoreDTO.getSubjectId());
        score.setScore1(scoreDTO.getScore1());
        score.setScore2(scoreDTO.getScore2());
        scoreRepository.save(score);
    }

    // Phương thức để lấy tất cả điểm
    public List<ScoreDTO> getAllScores() {
        return scoreRepository.findAll().stream().map(score -> {
            ScoreDTO dto = new ScoreDTO();
            dto.setStudentScoreId(score.getStudentScoreId());
            dto.setStudentId(score.getStudentId());
            dto.setSubjectId(score.getSubjectId());
            dto.setScore1(score.getScore1());
            dto.setScore2(score.getScore2());
            return dto;
        }).collect(Collectors.toList());
    }

    // Phương thức để lấy điểm của một sinh viên cụ thể
    public List<ScoreDTO> getScoresByStudentId(Long studentId) {
        return scoreRepository.findByStudentId(studentId).stream().map(score -> {
            ScoreDTO dto = new ScoreDTO();
            dto.setStudentScoreId(score.getStudentScoreId());
            dto.setStudentId(score.getStudentId());
            dto.setSubjectId(score.getSubjectId());
            dto.setScore1(score.getScore1());
            dto.setScore2(score.getScore2());
            return dto;
        }).collect(Collectors.toList());
    }
}
