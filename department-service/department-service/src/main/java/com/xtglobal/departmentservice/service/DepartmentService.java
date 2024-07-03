package com.xtglobal.departmentservice.service;

import com.xtglobal.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentByCode(String code);
}
