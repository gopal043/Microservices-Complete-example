package com.xtglobal.departmentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String departmentName;
	private String departmentDescription;
	private String departCode;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Department(Long id, String departmentName, String departmentDescription, String departCode) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
		this.departCode = departCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	public String getDepartCode() {
		return departCode;
	}
	public void setDepartCode(String departmentCode) {
		this.departCode = departmentCode;
	}
	
	
}
