package com.xtglobal.organizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xtglobal.organizationservice.dto.OrganizationDto;
import com.xtglobal.organizationservice.service.OrganizationService;

@RestController
@RequestMapping("api/organizations")
public class Controller {
	
	private OrganizationService organizationservice;

	public Controller(OrganizationService organizationservice) {
		super();
		this.organizationservice = organizationservice;
	}

	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto dto){
		OrganizationDto savedOrganization = organizationservice.saveOrganization(dto);
		
		return new ResponseEntity<> (savedOrganization,HttpStatus.CREATED);
	}
	
	@GetMapping("{code}")
	public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
	
		OrganizationDto organizationDto = organizationservice.getOrganizationByCode(organizationCode);
		
		return new ResponseEntity<OrganizationDto>(organizationDto,HttpStatus.OK);
	}
	
}
