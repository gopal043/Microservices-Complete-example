package com.xtglobal.organizationservice.service;

import com.xtglobal.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

	OrganizationDto saveOrganization(OrganizationDto dto);
	
	OrganizationDto getOrganizationByCode(String organizationCode);
}
