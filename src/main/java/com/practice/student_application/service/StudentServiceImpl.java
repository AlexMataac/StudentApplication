package com.practice.student_application.service;

import com.practice.student_application.entity.Student;
import com.practice.student_application.exception.StudentNotFoundException;
import com.practice.student_application.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;
    @Override
    public List<Student> getStudentInformation(Student student) throws StudentNotFoundException {
        return repository.findAll();
    }

    @Override
    public Optional<Student> findStudentnById(Long id) throws StudentNotFoundException {
        Optional<Student> studentOptional = repository.findById(id);
        if (studentOptional.isPresent()) {
            return repository.findById(id).filter(student -> student.getStudentId() == id);
        } else throw new StudentNotFoundException("STUDENT NOT FOUND");
    }


    @Override
    public Student addStudentInformation(Student student) {
        return repository.save(student);
    }

    @Override
    public Student updateStudentInformation(Student student, Long id) throws StudentNotFoundException {
        return repository.findById(id).map(student1 -> {
            student1.setFirstName(student.getFirstName());
            student1.setMiddleName(student.getMiddleName());
            student1.setLastName(student.getLastName());
            student1.setFullName(student.getFullName());
            student1.setAge(student.getAge());
            student1.setGender(student.getGender());
            student1.setLocation(student.getLocation());
            student1.setBirthDate(student.getBirthDate());
            student1.setPhoneNumber(student.getPhoneNumber());
            student1.setIsActive(student.getIsActive());
            return repository.save(student1);
        }).orElseThrow(() -> new StudentNotFoundException("Not Found"));
    }

    @Override
    public void deleteStudentInformation(Long id) throws StudentNotFoundException {
        Optional<Student> studentOptional = repository.findById(id);
        if (studentOptional.isEmpty()) {
            repository.findById(id).stream().filter(student -> student.getStudentId() == id);
        } else repository.delete(studentOptional.get());
    }
}
