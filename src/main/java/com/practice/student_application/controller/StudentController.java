package com.practice.student_application.controller;

import com.practice.student_application.dto.StudentRequest;
import com.practice.student_application.entity.Student;
import com.practice.student_application.exception.StudentNotFoundException;
import com.practice.student_application.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = {"http://localhost:3000/"})
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent () {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudent (@PathVariable Long id) throws StudentNotFoundException {
        return ResponseEntity.ok(service.findStudent(id));
    }
    @PostMapping
    public ResponseEntity<Student> addStudent (@RequestBody @Valid StudentRequest studentRequest) {
        return new ResponseEntity<>(service.addStudent(studentRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody @Valid StudentRequest studentRequest, @PathVariable Long id) throws StudentNotFoundException {
        return new ResponseEntity<>(service.updateStudent(studentRequest, id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentInformation (@PathVariable Long id) throws StudentNotFoundException {
        service.deleteStudent(id);
        return new ResponseEntity<>("The student has been deleted", HttpStatus.OK);
    }
}
