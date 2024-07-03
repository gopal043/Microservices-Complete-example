package com.xtglobal.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xtglobal.departmentservice.dto.DepartmentDto;
import com.xtglobal.departmentservice.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
	name ="Department Service -DepartmentController",
	description = "Department COntroller Exposses REST API's for Department-service"
)

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@Operation(
	    summary = "Save Department REST API",
	    description = "Save Department REST API is used to save department object in daabase"
	)
	@ApiResponse(
	    responseCode = "201",
	    description = "HTTP Status 201 CREATED"
	)
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		
		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
		
		return new ResponseEntity<DepartmentDto>(savedDepartment,HttpStatus.CREATED);
	}
	
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departCode){
		
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(departCode);
		
		return new ResponseEntity<DepartmentDto>(departmentDto,HttpStatus.OK);
	}
	
	
}
