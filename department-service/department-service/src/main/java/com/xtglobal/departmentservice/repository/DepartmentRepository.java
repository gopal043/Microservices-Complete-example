package com.xtglobal.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xtglobal.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Department findByDepartCode(String departCode);

}
