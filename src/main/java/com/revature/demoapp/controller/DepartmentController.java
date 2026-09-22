package com.revature.demoapp.controller;

import com.revature.demoapp.models.Departments;
import com.revature.demoapp.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
//    private Logger logger = Logger.getLogger();
    private DepartmentService service;

    public DepartmentController(DepartmentService service){
        this.service = service;
    }
    @Operation(summary = "create a dept", description = "Return an department after saving")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "department saved successfully"), @ApiResponse(responseCode = "401", description = "unauthorized"), @ApiResponse(responseCode = "400", description = "bad request sent")
    })
    @PostMapping
    public ResponseEntity<Departments> saveDeparment(@RequestBody Departments dept){
        return  new ResponseEntity<>(service.saveDepartment(dept), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Departments>> getAllDepartments(){
        return new ResponseEntity<>(service.getAllDepartments(), HttpStatus.OK);
    }



}
