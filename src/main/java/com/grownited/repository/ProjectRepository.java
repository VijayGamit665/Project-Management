package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grownited.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

	@Query(value="select p.* from project p, project_user pu where p.project_id = pu.project_id and pu.user_id = :userId", nativeQuery=true)
	List<ProjectEntity> getUserByUserId(Integer userId);
	
	@Query(value="select count(*) from project", nativeQuery = true)
	 Integer getprojectcount();
		
	@Query(value="select count(*) from project where project_status_Id = 2", nativeQuery=true)
	Integer getongoinprojectByprojectstatusId();
	
	@Query(value="select p. * from project p where project_status_Id = 2", nativeQuery=true)
	List<ProjectEntity> getongoingprojectsByprojectstatusId(Integer month);
	
	@Query(value="select count(*) from project where project_status_Id = 4", nativeQuery=true)
	Integer getpipelineprojectByprojectstatusId();
	
	@Query(value="select p. * from project p where project_status_Id = 4", nativeQuery=true)
	List<ProjectEntity> getpipelineprojectsByprojectstatusId(Integer month);
	
	@Query(value="select count(*) from project where month(project_completion_date) = :month", nativeQuery=true)
	Integer getCompletedprojectByproject(Integer month);
	
	@Query(value="select p. * from project p where month(project_completion_date) = :month", nativeQuery=true)
	List<ProjectEntity> getdueCompletedprojectByproject(Integer month);

	

	

	
}
