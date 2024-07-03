package com.xtglobal.employeeservice.dto;

public class DepartmentDto {

	private Long id;
	private String departmentName;
	private String departmentDescription;
	private String departCode;
	public DepartmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentDto(Long id, String departmentName, String departmentDescription, String departCode) {
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
	public void setDepartCode(String departCode) {
		this.departCode = departCode;
	}
	
	
}
