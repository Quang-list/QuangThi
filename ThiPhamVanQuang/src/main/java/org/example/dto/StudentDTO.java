package org.example.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private Long studentId;
    private String studentCode;
    private String fullName;
    private String address;
}
