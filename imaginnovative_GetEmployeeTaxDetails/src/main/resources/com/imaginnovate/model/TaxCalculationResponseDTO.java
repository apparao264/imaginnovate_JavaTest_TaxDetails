package com.imaginnovate.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxCalculationResponseDTO {
	
	    private String employeeCode;
	    private String firstName;
	    private String lastName;
	    private Double yearlySalary;
	    private Double taxAmount;
	    private Double cessAmount;

}
