package com.practice.student_application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class StudentRequest {

    @Pattern(regexp = "[a-zA-Z-\\sñ]+")
    @Size(min = 2, max = 60, message = "Maximum characters is 60")
    @NotNull(message = "firstName shouldn't be null")
    private String firstName;

    @Pattern(regexp = "[a-zA-Z-\\sñ]+")
    @Size(min = 2, max = 50, message = "Maximum characters is 50")
    @NotNull(message = "middleName shouldn't be null")
    private String middleName;

    @Pattern(regexp = "[a-zA-Z-\\sñ]+")
    @Size(min = 2, max = 50, message = "Maximum characters is 50")
    @NotNull(message = "lastName shouldn't be null")
    private String lastName;

    @Email(message = "invalid email address")
    @Column(unique = true)
    private String email;

    @Min(16)
    @Max(25)
    @NotNull(message = "age shouldn't be null")
    private int age;

    @NotNull(message = "gender shouldn't be null")
    private String gender;

    @NotBlank(message = "nationality shouldn't be blank")
    public String nationality;

    @NotBlank(message = "nationality shouldn't be blank")
    private String location;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @NotNull
    @Pattern(regexp = "^\\d{11}$", message = "invalid phone number entered")
    private String phoneNumber;
}
