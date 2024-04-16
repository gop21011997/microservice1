package com.microservice.employeeservice.controller;


import com.microservice.employeeservice.model.Employee;
import com.microservice.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    //To enable the logger slf4j we need to define a logger variable as follows
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping()
    public String addEmployee(@RequestBody Employee employee){
        LOGGER.info(" add : {}",employee);
        this.employeeRepository.addEmployee(employee);
        return " added successfully";
    }

    @GetMapping("/{employeeId}")
    public Employee findEmployeeById(@PathVariable(value ="employeeId") Long employeeId){
        LOGGER.info(" find by id : {}",employeeId);
        return this.employeeRepository.findEmployeeById(employeeId);
    }

    @GetMapping()
    public List<Employee> findAllEmployees(){
        LOGGER.info(" find all");
        return this.employeeRepository.findAllEmployees();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findAllEmployeesByDepartmentId(
            @PathVariable(value = "departmentId") Long departmentId){
        LOGGER.info(" find all");
        return this.employeeRepository.findAllEmployeesByDepartmentId(departmentId);
    }

}
