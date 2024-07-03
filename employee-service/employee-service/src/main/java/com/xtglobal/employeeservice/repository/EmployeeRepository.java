package com.xtglobal.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xtglobal.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
