package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grownited.entity.TaskUserEntity;

public interface TaskUserRepository extends JpaRepository<TaskUserEntity, Integer> {

}
