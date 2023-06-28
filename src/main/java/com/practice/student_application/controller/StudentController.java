package com.practice.student_application.controller;

import com.practice.student_application.entity.Student;
import com.practice.student_application.exception.StudentNotFoundException;
import com.practice.student_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudentInformation (Student student) throws StudentNotFoundException {
        List<Student> studentList = service.getStudentInformation(student);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> findStudentById (@PathVariable Long id) throws StudentNotFoundException {
        Optional<Student> studentOptional = service.findStudentnById(id);
        return new ResponseEntity<Optional<Student>>(studentOptional, HttpStatus.OK);
    }
    @PostMapping
    public Student addStudentInformation (@RequestBody Student student) {
        return service.addStudentInformation(student);
    }

    @PutMapping("/{id}")
    public Student updateStudentInformation (@RequestBody Student student, @PathVariable Long id) throws StudentNotFoundException {
        return service.updateStudentInformation(student, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentInformation (@PathVariable Long id) throws StudentNotFoundException {
        service.deleteStudentInformation(id);
        return new ResponseEntity<>("The student has been deleted", HttpStatus.OK);
    }
}
