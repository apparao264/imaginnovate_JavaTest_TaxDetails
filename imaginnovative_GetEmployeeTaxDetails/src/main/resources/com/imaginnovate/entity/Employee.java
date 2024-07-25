package com.imaginnovate.entity;

import lombok.Data;

@Data
@Entity
@Table
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(value = "FIRST_NAME")
    private String firstName;

    @Column(value = "LAST_NAME")
    private String lastName;

    @Column(value = "EMAIL")
    private String email;

    @Column(value= "PHONE_NUMBER")
    private String phoneNumbers;

    @Column(value = "DOJ")
    private Date dateOfJoining;

    @Column(value = "SALARY")
    private Double salary;


}
