package com.jheezy.firstproject.service;

import com.jheezy.firstproject.entity.Department;
import com.jheezy.firstproject.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService service;
    @MockBean
    private DepartmentRepository departmentRepository;


    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("Business").
                departmentAddress("Adenta").departmentCode("GH700").build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Business")).
                thenReturn(department);

    }

    @Test
    @DisplayName("Get data based on the valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldBeFound() {
        String departmentName = "Business";
        Department found = service.getDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}