package org.example.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ScoreDTO {
    private Long studentScoreId;
    private Long studentId;
    private Long subjectId;
    private double score1;
    private double score2;
}
