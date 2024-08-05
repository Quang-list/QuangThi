package org.example.controller;

import ch.qos.logback.core.model.Model;
import org.example.dto.ScoreDTO;
import org.example.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/scores")
    public String getAllScores(Model model) {
        model.addAttribute("scores", scoreService.getAllScores());
        return "scores";
    }

    @PostMapping("/scores")
    public String addScore(@RequestParam Long studentId, @RequestParam Long subjectId, @RequestParam double score1, @RequestParam double score2) {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setStudentId(studentId);
        scoreDTO.setSubjectId(subjectId);
        scoreDTO.setScore1(score1);
        scoreDTO.setScore2(score2);
        scoreService.addScore(scoreDTO);
        return "redirect:/scores";
    }
}
