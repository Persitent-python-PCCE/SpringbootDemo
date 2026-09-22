package com.revature.demoapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.HashMap;

//@Notnull
//@NotBlank @NotEmpty
//@Min @Max @Size(min = 3, max = 100)
//@Postive
//@Email
//@Pattern("regex")
public class EmployeeRequest {
    @NotBlank
    private String name;
    @Email
    private String email;
    @Min(18)
    private int age;
    private String role;
    private HashMap<String, Integer> dept;

    public EmployeeRequest(String name, String email, String role, HashMap<String, Integer> dept) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.dept = dept;
    }

    public EmployeeRequest(){}

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public HashMap<String, Integer> getDept() {
        return dept;
    }

    public void setDept(HashMap<String, Integer> dept) {
        this.dept = dept;
    }
}
