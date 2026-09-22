package com.revature.demoapp.service;

import com.revature.demoapp.models.Departments;
import com.revature.demoapp.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repo){
        this.repository = repo;
    }

    public Departments saveDepartment(Departments dept){
        return  repository.save(dept);
    }

    public List<Departments> getAllDepartments(){
        return repository.findAll();
    }
}
