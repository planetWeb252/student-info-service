package com.student.info_service.controller;

import com.student.info_service.model.Student;
import com.student.info_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable long id){
        return  ResponseEntity.ok(studentRepository.findById(id));
    }
}
