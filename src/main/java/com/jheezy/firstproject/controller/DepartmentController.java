package com.jheezy.firstproject.controller;

import com.jheezy.firstproject.entity.Department;
import com.jheezy.firstproject.error.DepartmentNotFoundException;
import com.jheezy.firstproject.service.DepartmentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
   private DepartmentService service;

  


    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return service.saveDepartment(department);

    }

    @GetMapping("allDepartments")
    public List<Department> fetchAllDepartments() {
        return service.fetchAllDepartments();

    }

    @GetMapping("/fetchDepartment/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return service.getDepartmentById(id);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id) {
        service.deleteDepartmentById(id);
        return "Department deleted Successfully";
    }

    @PutMapping("/updateDepartment/{id}")
    public Department updateDepartment(@PathVariable("id") Long id ,@RequestBody Department department) {
        return service.updateDepartment(id, department);
    }

    @GetMapping("/fetchDepartment/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) {
        return service.getDepartmentByName(departmentName);
    }
}
