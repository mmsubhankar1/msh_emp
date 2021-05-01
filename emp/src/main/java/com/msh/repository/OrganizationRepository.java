package com.msh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msh.dto.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
