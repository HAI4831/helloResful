package com.example.helloRestful.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees") // Optional: Specifies the table name in the database
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // First Name
    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First name is mandatory")
    @Size(max = 50, message = "First name can have at most 50 characters")
    private String firstName;

    // Last Name
    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last name is mandatory")
    @Size(max = 50, message = "Last name can have at most 50 characters")
    private String lastName;

    // Email Address
    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    // Phone Number
    @Column(name = "phone_number")
    @Size(max = 20, message = "Phone number can have at most 20 characters")
    private String phoneNumber;

    // Hire Date
    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    // Salary
    @Column(name = "salary", nullable = false)
    private Double salary;

    // Department (Assuming a simple String field; alternatively, it could be a relationship)
    @Column(name = "department", nullable = false)
    @NotBlank(message = "Department is mandatory")
    @Size(max = 100, message = "Department can have at most 100 characters")
    private String department;

}
