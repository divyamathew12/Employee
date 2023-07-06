package com.example.employee.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @Email(message="Invalid Email ID")
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Pattern(regexp= "\\d{10}", message="Phone Number must be 10 digit")
    @NotBlank(message = "Phone Number is Mandatory")
    @Column(name = "phone")
    private String phone;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    public Employee (Long id,String name,String email,String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;

    }
    public Employee(Department department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

}
