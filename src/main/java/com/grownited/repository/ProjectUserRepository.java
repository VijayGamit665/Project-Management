package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grownited.entity.ProjectUserEntity;

public interface ProjectUserRepository extends JpaRepository<ProjectUserEntity, Integer> {
	
	

}
