package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grownited.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	UserEntity findByEmailAndPassword(String email,String password);
	List <UserEntity> findByFirstName(String firstName);
	List <UserEntity> findByFirstNameAndLastName(String firstName , String lastName);

}
