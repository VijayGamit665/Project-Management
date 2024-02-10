package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grownited.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

}
