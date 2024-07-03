package com.xtglobal.employeeservice.service;

import com.xtglobal.employeeservice.dto.APIResponseDto;
import com.xtglobal.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	APIResponseDto getEmployeeById(Long id);
	
}
