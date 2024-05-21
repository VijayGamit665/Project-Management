package com.grownited.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ModuleEntity;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, Integer> {

	List<ModuleEntity> findByProjectId(Integer projectId);

	@Query(value = "select * from module where status_id <> 5 and project_id =:projectId", nativeQuery = true)
	List<ModuleEntity> getNotCompletedModule(Integer projectId);

	@Query(value = "select SUM(total_utilized_hours) FROM module WHERE project_id = :projectId", nativeQuery = true)
	Integer getTotalUtilizedHoursSumByProjectId(Integer projectId);
	
	
}
