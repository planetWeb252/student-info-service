package com.student.info_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreatedRequestDTO {
    private long studentId;
    private String name;
    private int age;
}
