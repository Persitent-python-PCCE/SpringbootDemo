package com.revature.demoapp.controller;

import com.revature.demoapp.dto.EmployeeRequest;
import com.revature.demoapp.models.Departments;
import com.revature.demoapp.models.Employee;
import com.revature.demoapp.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeRequest emp_req){
        log.trace("");
        log.debug("");
        log.info("");
        log.warn("");
        log.error("");
        Employee emp = new Employee(null,emp_req.getName(), emp_req.getEmail(), emp_req.getRole(), new Departments(emp_req.getDept().get("id")));
        return new ResponseEntity<>(service.saveEmployee(emp), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
    }

//    @GetMapping("/search/role/{role_name}")
//    public ResponseEntity<List<Employee>> getByRole(@PathVariable String role_name, @RequestParam("pageno") int pgno, @RequestParam("size") int pagesize, @RequestParam("sort_on") String sort_col, @RequestParam(name = "sort_by", required = false) String order){
//        return new ResponseEntity<>();
//    }

}
