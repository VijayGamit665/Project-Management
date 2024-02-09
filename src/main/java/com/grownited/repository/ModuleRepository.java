package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grownited.entity.ModuleEntity;

public interface ModuleRepository extends JpaRepository<ModuleEntity, Integer> {

}
