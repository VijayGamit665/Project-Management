package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.DailyEffortsEntity;

@Repository
public interface DailyEffortsRepository extends JpaRepository<DailyEffortsEntity, Integer> {

}