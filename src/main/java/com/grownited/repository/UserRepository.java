package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	UserEntity findByEmailAndPassword(String email,String password);
	List <UserEntity> findByFirstName(String firstName);
	List <UserEntity> findByFirstNameAndLastName(String firstName , String lastName);

	UserEntity findByEmail(String email);

	
	// task user Query
	@Query(value="select u.* from user u, task_user tu where u.user_id = tu.user_id and tu.task_id = :taskId and tu.assign_status = 1", nativeQuery=true)
	List<UserEntity> getUserBytaskId(Integer taskId);
	
	@Query(value = "select u.* from user u, task_user tu where u.user_id = tu.user_id and tu.task_id = :taskId and tu.assign_status = 2",nativeQuery = true)
	List<UserEntity> getUserBytaskIdRevoke(Integer taskId);
	
	@Query(value = "select u.* from user u, task_user tu where u.user_id = tu.user_id and tu.task_id = :taskId and tu.assign_status = 3",nativeQuery = true)
	List<UserEntity> getUserBytaskIdHold(Integer taskId);
	
	// project user Query
	@Query(value="select u.* from user u, project_user pu where u.user_id = pu.user_id and pu.project_id = :projectId and pu.assign_status = 1", nativeQuery=true)
	List<UserEntity> getUserByProjectId(Integer projectId);
	
	@Query(value="select u.* from user u, project_user pu where u.user_id = pu.user_id and pu.project_id = :projectId and pu.assign_status = 2", nativeQuery=true)
	List<UserEntity> getUserByprojectIdRevoke(Integer projectId);
	
	@Query(value="select u.* from user u, project_user pu where u.user_id = pu.user_id and pu.project_id = :projectId and pu.assign_status = 3", nativeQuery=true)
	List<UserEntity> getUserByprojectIdHold(Integer projectId);
	
	@Query(value="select u.* from user u where role_id =3",nativeQuery=true)
	List<UserEntity> findByroleId();
	
	@Query(value="select u.* from user u where role_id =2",nativeQuery=true)
	List<UserEntity> findBymroleId();
	
	
	
	

}
