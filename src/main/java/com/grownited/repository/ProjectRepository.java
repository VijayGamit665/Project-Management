package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grownited.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

}
