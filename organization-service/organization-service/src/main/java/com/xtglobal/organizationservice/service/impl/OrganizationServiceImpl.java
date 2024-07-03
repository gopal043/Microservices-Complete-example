package com.xtglobal.organizationservice.service.impl;

import org.springframework.stereotype.Service;

import com.xtglobal.organizationservice.dto.OrganizationDto;
import com.xtglobal.organizationservice.entity.Organization;
import com.xtglobal.organizationservice.entity.mapper.OrganizationMapper;
import com.xtglobal.organizationservice.repository.OrganizationRepository;
import com.xtglobal.organizationservice.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService{

	
	public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
		super();
		this.organizationRepository = organizationRepository;
	}

	private OrganizationRepository organizationRepository;
	
	@Override
	public OrganizationDto saveOrganization(OrganizationDto dto) {
		// TODO Auto-generated method stub
		
		Organization organization = OrganizationMapper.mapToOrganization(dto);
		Organization savedOrganization = organizationRepository.save(organization);
		OrganizationDto savedOrganizationDto = OrganizationMapper.mapToOrganizationDto(savedOrganization);
		
		return savedOrganizationDto;
	}

	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {
		
		Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
		return OrganizationMapper.mapToOrganizationDto(organization);
	}

}
