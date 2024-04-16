package com.microservice.departmentservice.repository;

import com.microservice.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    private List<Department> departmentList = new ArrayList<>();

    public Department addDepartment(Department department){
        departmentList.add(department);
        return department;
    }

    public Department findDepartmentById(Long id){
        return departmentList.stream().filter( e -> e.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<Department> findAllDepartments(){
        return departmentList;
    }
}
