package com.jheezy.firstproject.service;

import com.jheezy.firstproject.entity.Department;
import com.jheezy.firstproject.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
  public  Department saveDepartment(Department department);

  public  List<Department> fetchAllDepartments();


  public  Department getDepartmentById(Long id) throws DepartmentNotFoundException;

  public void deleteDepartmentById(Long id);

  public  Department updateDepartment(Long id, Department department);

  public  Department getDepartmentByName(String departmentName);
}
