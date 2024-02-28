package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grownited.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	UserEntity findByEmailAndPassword(String email,String password);
	List <UserEntity> findByFirstName(String firstName);
	List <UserEntity> findByFirstNameAndLastName(String firstName , String lastName);

	UserEntity findByEmail(String email);

	@Query(value="select u.* from user u, project_user pu where u.user_id = pu.user_id and pu.project_id = :projectId", nativeQuery=true)
	List<UserEntity> getUserByProjectId(Integer projectId);
}
