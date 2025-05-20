package com.student.info_service.Service;

import com.student.info_service.DTO.StudentCreatedRequestDTO;
import com.student.info_service.model.Student;
import com.student.info_service.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<?> createdStudent(StudentCreatedRequestDTO dto) {
        // Check if the student with the given ID already exists
        if (studentRepository.existsById(dto.getId())) {
            return ResponseEntity.badRequest().body("Student with this ID already exists");
        }
        // Create a new Student entity and save it to the database
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        // Save the student to the repository
        studentRepository.save(student);
        return ResponseEntity.ok("Student created successfully");
    }
}
