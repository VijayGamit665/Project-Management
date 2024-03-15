package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ProjectUserEntity;

@Repository
public interface ProjectUserRepository extends JpaRepository<ProjectUserEntity, Integer> {

	ProjectUserEntity findByprojectIdAndUserId(Integer projectId, Integer userId);

		
	
}
