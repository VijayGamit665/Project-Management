package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grownited.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

	@Query(value="select p.* from project p, project_user pu where p.project_id = pu.project_id and pu.user_id = :userId", nativeQuery=true)
	List<ProjectEntity> getUserByUserId(Integer userId);

	
}
