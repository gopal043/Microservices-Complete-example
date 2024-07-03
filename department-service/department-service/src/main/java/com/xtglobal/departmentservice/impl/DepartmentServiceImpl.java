package com.xtglobal.departmentservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.xtglobal.departmentservice.dto.DepartmentDto;
import com.xtglobal.departmentservice.entity.Department;
import com.xtglobal.departmentservice.repository.DepartmentRepository;
import com.xtglobal.departmentservice.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentRepository departmentRepository;
	
	@Autowired
	private Environment environment;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		
		Department department = new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(),
				departmentDto.getDepartCode()
			);
		
		Department savedDepartment = departmentRepository.save(department);
		
		DepartmentDto savedDepartmentDto = new DepartmentDto(
				      savedDepartment.getId(),
				      savedDepartment.getDepartmentName(),
				      savedDepartment.getDepartmentDescription(),
				      savedDepartment.getDepartCode()
				);
		
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departCode) {

       Department department = departmentRepository.findByDepartCode(departCode);
       
       DepartmentDto departmentDto = new DepartmentDto(
    		   department.getId(),
    		   department.getDepartmentName(),
    		   department.getDepartmentDescription(),
    		   department.getDepartCode() +" port : "+environment.getProperty("local.server.port")
    		   );
       
		return departmentDto;
	}
	
	

}
