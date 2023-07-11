package com.practice.student_application.service;

import com.practice.student_application.dto.StudentRequest;
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
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student findStudent(Long id) throws StudentNotFoundException {
        Student student = repository.findByStudentId(id);
        if(student!=null) {
            return student;
        } else {
            throw new StudentNotFoundException("student not found with id: " + id);
        }
    }


    @Override
    public Student addStudent(StudentRequest studentRequest) {
        Student student = Student.build(1L, studentRequest.getFirstName(), studentRequest.getMiddleName(),
                studentRequest.getLastName(), studentRequest.getEmail(), studentRequest.getAge(),
                studentRequest.getGender(), studentRequest.nationality, studentRequest.getLocation(), studentRequest.getBirthDate(),
                studentRequest.getPhoneNumber());
        return repository.save(student);
    }

    @Override
    public Student updateStudent(StudentRequest studentRequest, Long id) throws StudentNotFoundException {
        return repository.findById(id).map(student1 -> {
            student1.setFirstName(studentRequest.getFirstName());
            student1.setMiddleName(studentRequest.getMiddleName());
            student1.setLastName(studentRequest.getLastName());
            student1.setEmail(studentRequest.getEmail());
            student1.setAge(studentRequest.getAge());
            student1.setGender(studentRequest.getGender());
            student1.setNationality(studentRequest.getNationality());
            student1.setLocation(studentRequest.getLocation());
            student1.setBirthDate(studentRequest.getBirthDate());
            student1.setPhoneNumber(studentRequest.getPhoneNumber());

            return repository.save(student1);
        }).orElseThrow(() -> new StudentNotFoundException("student not found with id: " + id));
    }

    @Override
    public void deleteStudent(Long id) throws StudentNotFoundException {
        Optional<Student> studentOptional = repository.findById(id);
        if (studentOptional.isEmpty()) {
            repository.findById(id).stream().filter(student -> student.getStudentId() == id);
        } else repository.delete(studentOptional.get());
    }
}
