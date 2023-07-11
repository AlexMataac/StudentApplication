package com.practice.student_application.service;

import com.practice.student_application.dto.StudentRequest;
import com.practice.student_application.entity.Student;
import com.practice.student_application.exception.StudentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Student findStudent(Long id) throws StudentNotFoundException;

    Student addStudent(StudentRequest studentRequest);

    Student updateStudent(StudentRequest studentRequest, Long id) throws StudentNotFoundException;
    void deleteStudent(Long id) throws StudentNotFoundException;
}
