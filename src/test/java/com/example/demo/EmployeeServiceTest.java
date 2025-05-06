package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    private Employee sampleEmployee;

    @BeforeEach
    public void setUp() {
        sampleEmployee = new Employee();
        sampleEmployee.setName("John Doe");
        sampleEmployee.setEmail("john@example.com");
    }

    @Test
    public void testSaveEmployee() {
        Employee saved = employeeService.saveEmployee(sampleEmployee);
        assertNotNull(saved.getId());
        assertEquals("John Doe", saved.getName());
    }

    @Test
    public void testGetAllEmployees() {
        employeeService.saveEmployee(sampleEmployee);
        List<Employee> employees = employeeService.getAllEmployees();
        assertTrue(employees.size() > 0);
    }

    @Test
    public void testGetEmployeeById() {
        Employee saved = employeeService.saveEmployee(sampleEmployee);
        Employee found = employeeService.getEmployeeById(saved.getId());
        assertEquals("John Doe", found.getName());
    }

    @Test
    public void testUpdateEmployee() {
        Employee saved = employeeService.saveEmployee(sampleEmployee);
        Employee update = new Employee();
        update.setName("Jane Doe");
        update.setEmail("jane@example.com");

        Employee updated = employeeService.updateEmployee(saved.getId(), update);
        assertEquals("Jane Doe", updated.getName());
    }

    @Test
    public void testDeleteEmployee() {
        Employee saved = employeeService.saveEmployee(sampleEmployee);
        employeeService.deleteEmployee(saved.getId());

        List<Employee> all = employeeService.getAllEmployees();
        assertTrue(all.stream().noneMatch(e -> e.getId().equals(saved.getId())));
    }
}
