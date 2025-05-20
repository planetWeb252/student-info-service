package com.student.info_service.controller;

import com.student.info_service.DTO.StudentCreatedRequestDTO;
import com.student.info_service.Service.StudentService;
import com.student.info_service.model.Student;
import com.student.info_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id){
        return  studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentCreatedRequestDTO dto){
        return  studentService.createdStudent(dto);
    }
}
