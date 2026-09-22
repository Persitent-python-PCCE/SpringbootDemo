package com.revature.demoapp.service;

import com.revature.demoapp.models.Employee;
import com.revature.demoapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repo){
        this.repository = repo;
    }

    public Employee saveEmployee(Employee emp){
        return repository.save(emp);
    }

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public List<Employee> getEmployeeByRole(String role, int page_no, int page_size){
        Pageable pageable = PageRequest.of(page_no,page_size, Sort.by("id").descending());
        Page<Employee> employess = repository.findByRole(role, pageable);
        return employess.getContent();
    }
}
