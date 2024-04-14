package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grownited.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

	List<TaskEntity> findByModuleId(Integer moduleId);

	@Query(value = "select t.* from task t, task_user tu where t.task_id = tu.task_id and tu.user_id = :userId AND assign_status=1", nativeQuery = true)
	List<TaskEntity> getUserByUserId(Integer userId);

	@Query(value = "select t.* from task t, task_user tu where t.task_id = tu.task_id and tu.user_id = :userId AND assign_status=2", nativeQuery = true)
	List<TaskEntity> getRevokeUserByUserId(Integer userId);

	@Query(value = "select t.* from task t, task_user tu where t.task_id = tu.task_id and tu.user_id = :userId AND assign_status=3", nativeQuery = true)
	List<TaskEntity> getHoldUserByUserId(Integer userId);

	@Query(value = "select * from task where status_id <> 5 and module_id =:moduleId", nativeQuery = true)
	List<TaskEntity> getNotCompletedTask(Integer moduleId);

	@Query(value = "select SUM(total_utilized_hours) FROM task WHERE module_id = :moduleId", nativeQuery = true)
	Integer getTotalUtilizedHoursSumByModuleId(Integer moduleId);
	
}
