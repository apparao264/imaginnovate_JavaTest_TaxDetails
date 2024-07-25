package com.imaginnovate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.repository.EmployeeRepository;


import com.imaginnovate.model.EmployeeDTO;
import com.imaginnavative.entity.Employee;

@Service
public class EmployeeService {

	 @Autowired
	 private EmployeeRepository employeeRepository;

	 public TaxCalculationResponseDTO calculateTaxForEmployee(Long employeeId) {
	      Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));

	      LocalDate doj = employee.getDateOfJoining();
	      LocalDate currentDate = LocalDate.now();
	      LocalDate startOfFinancialYear = LocalDate.of(currentDate.getYear(), 4, 1);

	      Long monthsWorked = ChronoUnit.MONTHS.between(doj.withDayOfMonth(1), currentDate.withDayOfMonth(1));
	      Long daysWorked = ChronoUnit.DAYS.between(doj, doj.plusMonths(1).withDayOfMonth(1));
	      Double monthlySalary = employee.getSalary();

	      Double yearlySalary = (monthlySalary * monthsWorked) + (monthlySalary / 30 * daysWorked);

	      Double taxAmount = calculateTax(yearlySalary);
	      Double cessAmount = calculateCess(yearlySalary);

	      return new TaxCalculationResponseDTO(
	                employee.getEmployeeCode(),
	                employee.getFirstName(),
	                employee.getLastName(),
	                yearlySalary,
	                taxAmount,
	                cessAmount
	        );
	    }

	    private Double calculateTax(Double yearlySalary) {
	        if (yearlySalary <= 250000) {
	            return 0;
	        } else if (yearlySalary <= 500000) {
	            return (yearlySalary - 250000) * 0.05;
	        } else if (yearlySalary <= 1000000) {
	            return (250000 * 0) + (250000 * 0.05) + ((yearlySalary - 500000) * 0.10);
	        } else {
	            return (250000 * 0) + (250000 * 0.05) + (500000 * 0.10) + ((yearlySalary - 1000000) * 0.20);
	        }
	    }

	    private Double calculateCess(Double yearlySalary) {
	        if (yearlySalary > 2500000) {
	            return (yearlySalary - 2500000) * 0.02;
	        } else {
	            return 0;
	        }
	    }
	}	    
	    

}
