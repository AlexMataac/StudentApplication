package com.practice.student_application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "middle_name", nullable = false, length = 50)
    private String middleName;
    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;
    @Column(name = "full_name", nullable = false, length = 150)
    private String fullName;
    @Column(name = "age", nullable = false)
    private short age;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "birth_date", nullable = false)
    private String birthDate;
    @Column(name = "phone_number", nullable = false, length = 11)
    private String phoneNumber;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

}
