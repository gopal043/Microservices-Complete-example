package com.xtglobal.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xtglobal.employeeservice.dto.APIResponseDto;
import com.xtglobal.employeeservice.dto.EmployeeDto;
import com.xtglobal.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		
		
		return new ResponseEntity<EmployeeDto>(savedEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("{employee-id}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("employee-id") Long id){
		
		APIResponseDto apiResponseDto = employeeService.getEmployeeById(id);
				
		return new ResponseEntity<APIResponseDto>(apiResponseDto,HttpStatus.OK);
	}
}
