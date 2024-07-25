package com.imaginnovate.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	 @Autowired
	 private EmployeeService employeeService;

	 @GetMapping(value = "/tax/{id}")
	 public TaxCalculationResponseDTO getEmployeeTaxDetails(@PathVariable Long id) {
	     return employeeService.calculateTaxForEmployee(id);
	 }
}
