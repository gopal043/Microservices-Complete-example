package com.xtglobal.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xtglobal.organizationservice.entity.Organization;


public interface OrganizationRepository extends JpaRepository<Organization, Long>{

	Organization findByOrganizationCode(String organizationCode);
}
