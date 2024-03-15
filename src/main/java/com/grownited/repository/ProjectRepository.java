package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grownited.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

	// Developer Query
	@Query(value = "select p.* from project p, project_user pu where p.project_id = pu.project_id and pu.user_id = :userId", nativeQuery = true)
	List<ProjectEntity> getUserByUserId(Integer userId);

	@Query(value = "select count(*) from project p, project_user pu where p.project_id = pu.project_id and pu.user_id = :userId", nativeQuery = true)
	Integer getUserProjectByUserId(Integer userId);

	@Query(value = "SELECT COUNT(*) FROM project pr " + "INNER JOIN project_user pu ON pr.project_id = pu.project_id "
			+ "INNER JOIN user u ON pu.user_id = u.user_id "
			+ "WHERE u.user_id = :userId AND pr.project_status_id = 2", nativeQuery = true)

	Integer getongoinUserprojectByprojectstatusId(Integer userId);

	@Query(value = "SELECT pr. * FROM project pr " + "INNER JOIN project_user pu ON pr.project_id = pu.project_id "
			+ "INNER JOIN user u ON pu.user_id = u.user_id "
			+ "WHERE u.user_id = :userId AND pr.project_status_id = 2", nativeQuery = true)

	List<ProjectEntity> getUserongoinprojectByprojectstatusId(Integer userId);

	@Query(value = "SELECT COUNT(*) FROM project pr " + "INNER JOIN project_user pu ON pr.project_id = pu.project_id "
			+ "INNER JOIN user u ON pu.user_id = u.user_id "
			+ "WHERE u.user_id = :userId AND pr.project_status_id = 4", nativeQuery = true)

	Integer getuserpipelineprojectByprojectstatusId(Integer userId);

	@Query(value = "SELECT pr. * FROM project pr " + "INNER JOIN project_user pu ON pr.project_id = pu.project_id "
			+ "INNER JOIN user u ON pu.user_id = u.user_id "
			+ "WHERE u.user_id = :userId AND pr.project_status_id = 4", nativeQuery = true)
	List<ProjectEntity> getUserpipelineprojectByprojectstatusId(Integer userId);

	@Query(value = "SELECT COUNT(*) FROM project pr " + "INNER JOIN project_user pu ON pr.project_id = pu.project_id "
			+ "INNER JOIN user u ON pu.user_id = u.user_id "
			+ "WHERE u.user_id = :userId AND pr.project_status_id = 2 AND month(pr.project_completion_date) < :month", nativeQuery = true)
	Integer getuserduoprojectByprojectstatusId(Integer month, Integer userId);

	@Query(value = "SELECT pr. * FROM project pr " + "INNER JOIN project_user pu ON pr.project_id = pu.project_id "
			+ "INNER JOIN user u ON pu.user_id = u.user_id "
			+ "WHERE u.user_id = :userId AND pr.project_status_id = 2 AND month(pr.project_completion_date) < :month", nativeQuery = true)
	List<ProjectEntity> getuserDuoprojectByprojectstatusId(Integer month, Integer userId);

	
	// Admin Query
	@Query(value = "select count(*) from project", nativeQuery = true)
	Integer getprojectcount();

	@Query(value = "select count(*) from project where project_status_Id = 2", nativeQuery = true)
	Integer getongoinprojectByprojectstatusId();

	@Query(value = "select p. * from project p where project_status_Id = 2", nativeQuery = true)
	List<ProjectEntity> getongoingprojectsByprojectstatusId(Integer month);

	@Query(value = "select count(*) from project where project_status_Id = 4", nativeQuery = true)
	Integer getpipelineprojectByprojectstatusId();

	@Query(value = "select p. * from project p where project_status_Id = 4", nativeQuery = true)
	List<ProjectEntity> getpipelineprojectsByprojectstatusId(Integer month);

	@Query(value = "select count(*) from project where month(project_completion_date) < :month", nativeQuery = true)
	Integer getCompletedprojectBymonth(Integer month);

	@Query(value = "select p. * from project p where month(p.project_completion_date) < :month", nativeQuery = true)
	List<ProjectEntity> getdueCompletedprojectBymonth(Integer month);

	
}
