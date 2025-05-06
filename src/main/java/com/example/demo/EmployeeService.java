package com.example.demo;

import com.example.demo.Employee;
import com.example.demo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(EmployeeDTO employeeDTO) {
    	Employee employee=new Employee();
    	
    	employee.setName( employeeDTO.getName());
    	employee.setEmail(employeeDTO.getEmail());
    	employee.setPhoneNo(employeeDTO.getPhoneNo());
    	employee.setDesignation(employeeDTO.getDesignation());
    	
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee existing = employeeRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(employeeDetails.getName());
            existing.setEmail(employeeDetails.getEmail());
         
            return employeeRepository.save(existing);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

