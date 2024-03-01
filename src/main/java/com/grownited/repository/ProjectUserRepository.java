package com.grownited.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grownited.entity.ProjectUserEntity;

public interface ProjectUserRepository extends JpaRepository<ProjectUserEntity, Integer> {

	@Query(value="select u.* from user u, project_user pu where u.user_id = pu.user_id and pu.user_id = :userId", nativeQuery=true)
	List<ProjectUserEntity> getUserdeleteByuserId(Integer userId);

	
}
