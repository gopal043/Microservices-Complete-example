package com.xtglobal.employeeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employeess")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@Column(nullable = false,unique = true)
	private String email;
	
	private String departCode;
	
	private String organizationCode;
	
	public String getDepartCode() {
		return departCode;
	}

	public void setDepartCode(String departCode) {
		this.departCode = departCode;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public Employee(Long id, String firstName, String lastName, String email, String departCode,
			String organizationCode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.departCode = departCode;
		this.organizationCode = organizationCode;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", departCode=" + departCode + ", organizationCode=" + organizationCode + "]";
	}
	
	
}
