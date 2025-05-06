package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

@Table(name = "employee_table")

	public class Employee {

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id; 
	   
	    private String name;
	    private String email;
	    
	  

	    // Getters
	    public Long getId() { return id; }
	    public String getName() { return name; }
	    public String getEmail() { return email; }
	    

	    // Setters
	    public void setId(Long id) { this.id = id; }
	    public void setName(String name) { this.name = name; }
	    public void setEmail(String email) { this.email = email; }
	    
}


