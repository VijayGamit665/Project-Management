package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.DailyEffortsEntity;

@Repository
public interface DailyEffortsRepository extends JpaRepository<DailyEffortsEntity, Integer> {

	List<DailyEffortsEntity> findTopByTaskIdOrderByDailyDateDesc(Integer taskId);


	
}
