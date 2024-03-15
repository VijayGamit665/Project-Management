package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.TaskUserEntity;

@Repository
public interface TaskUserRepository extends JpaRepository<TaskUserEntity, Integer> {

	TaskUserEntity findBytaskIdAndUserId(Integer taskId, Integer userId);

	
}
