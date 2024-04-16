package com.microservice.departmentservice.controller;

import com.microservice.departmentservice.client.EmployeeClient;
import com.microservice.departmentservice.model.Department;
import com.microservice.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    //To enable the logger slf4j we need to define a logger variable as follows
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping()
    public String addDepartment(@RequestBody Department department){
        LOGGER.info("Department add : {}",department);
        this.departmentRepository.addDepartment(department);
        return "Department added successfully";
    }

    @GetMapping("/{departmentId}")
    public Department findDepartmentById(@PathVariable(value ="departmentId") Long id){
        LOGGER.info("Department find by id : {}",id);
        return this.departmentRepository.findDepartmentById(id);
    }

    @GetMapping()
    public List<Department> findAllDepartments(){
        LOGGER.info("Department find all");
        return this.departmentRepository.findAllDepartments();
    }

    @GetMapping("/with-employees")
    public List<Department> findAllDepartmentsWithEmployee(){
        LOGGER.info("Department find all");
        List<Department> list = this.departmentRepository.findAllDepartments();
        list.forEach(department ->
                department.setList(employeeClient.findAllEmployeesByDepartmentId(department.getId())));
        return list;
    }


}
