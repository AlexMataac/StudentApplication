package com.practice.student_application.service;

import com.practice.student_application.entity.Student;
import com.practice.student_application.exception.StudentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getStudentInformation(Student student) throws StudentNotFoundException;
    Optional<Student> findStudentnById(Long id) throws StudentNotFoundException;
    Student addStudentInformation(Student student);
    Student updateStudentInformation(Student student, Long id) throws StudentNotFoundException;
    void deleteStudentInformation(Long id) throws StudentNotFoundException;
}
