package com.example.demo;

import lombok.Data;

@Data

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    
    private Long phoneNo;
    private String designation;
    
}
