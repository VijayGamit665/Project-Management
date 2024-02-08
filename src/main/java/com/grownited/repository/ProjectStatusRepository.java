package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grownited.entity.ProjectStatusEntity;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatusEntity, Integer> {

}
