package com.microservice.employeeservice.repository;

import com.microservice.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    
    private List<Employee> employeeList = new ArrayList<>();
    public Employee addEmployee(Employee employee){
        employeeList.add(employee);
        return employee;
    }

    public Employee findEmployeeById(Long id){
        return employeeList.stream().filter(
                e -> e.id().equals(id)).findFirst().orElseThrow();
    }

    public List<Employee> findAllEmployees(){

        return employeeList;
    }

    public List<Employee> findAllEmployeesByDepartmentId(Long id) {

        return employeeList.stream().filter(
                e -> e.departmentId().equals(id)).collect(Collectors.toList());
    }
}
