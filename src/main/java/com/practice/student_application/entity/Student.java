package com.practice.student_application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Data

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "first_name", nullable = false, length = 60)
    private String firstName;
    @Column(name = "middle_name", nullable = false, length = 50)
    private String middleName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "email", length = 50, unique = true)
    private String email;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "nationality")
    public String nationality;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;


}
