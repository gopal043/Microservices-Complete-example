package com.xtglobal.employeeservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xtglobal.employeeservice.dto.APIResponseDto;
import com.xtglobal.employeeservice.dto.DepartmentDto;
import com.xtglobal.employeeservice.dto.EmployeeDto;
import com.xtglobal.employeeservice.dto.OrganizationDto;
import com.xtglobal.employeeservice.entity.Employee;
import com.xtglobal.employeeservice.repository.EmployeeRepository;
import com.xtglobal.employeeservice.service.APIClient;
import com.xtglobal.employeeservice.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	 private RestTemplate restTemplate;
	@Autowired(required = true)
	private APIClient apiClient;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub

		Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
				employeeDto.getEmail(), employeeDto.getDepartCode(), employeeDto.getOrganizationCode());

		Employee savedEmployee = employeeRepository.save(employee);

		EmployeeDto savedEmployeeDto = new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(),
				savedEmployee.getLastName(), savedEmployee.getEmail(), savedEmployee.getDepartCode(),
				savedEmployee.getOrganizationCode());

		return savedEmployeeDto;
	}

	// @Retry(name = "${spring.application.name}", fallbackMethod =
	// "getDefaultDepartment")
	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Override
	public APIResponseDto getEmployeeById(Long id) {
		// TODO Auto-generated method stub

		Employee employee = employeeRepository.findById(id).get();

		System.out.println("employee :: "+employee.toString());
		
		 ResponseEntity<DepartmentDto> responseEntity =
		 restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.
		  getDepartCode(), DepartmentDto.class);
		  DepartmentDto departmentDto = responseEntity.getBody();
		 
		  
		  
		ResponseEntity<OrganizationDto> dto=  
				restTemplate.getForEntity("http://localhost:8083/api/organizations/"+employee.getOrganizationCode(), OrganizationDto.class);

		OrganizationDto organizationDto =dto.getBody();
		
		// DepartmentDto departmentDto =
		// apiClient.getDepartment(employee.getDepartCode());

		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(),
				employee.getEmail(), employee.getDepartCode(), employee.getOrganizationCode());

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setDepartment(departmentDto);
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setOrganization(organizationDto);

		return apiResponseDto;
	}

	public APIResponseDto getDefaultDepartment(Long id) {

		Employee employee = employeeRepository.findById(id).get();
		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(),
				employee.getEmail(), employee.getDepartCode(), employee.getOrganizationCode());

		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartCode("RD001");
		departmentDto.setDepartmentDescription("Research and Development Department");
		departmentDto.setDepartmentName("R&D Department");

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setDepartment(departmentDto);
		apiResponseDto.setEmployee(employeeDto);

		return apiResponseDto;
	}

}
