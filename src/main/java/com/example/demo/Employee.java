package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

@Table(name = "employee_table")

	public class Employee {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "employee_id")
	    private Long id;

	    @Column(name = "employee_name", nullable = false, length = 50)
	    private String name;

	    @Column(name = "employee_email", nullable = false, unique = true, length = 150)
	    private String email;

	    @Column(name = "phone_number", nullable = false, unique = true)
	    private Long phoneNo;

	    @Column(name = "designation", nullable = false, length = 50)
	    private String designation;

}


