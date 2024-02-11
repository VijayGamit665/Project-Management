package com.grownited.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="taskUser")
public class TaskUserEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer taskUserId;
	private Integer userID;
	private Integer taskId;
	private Integer assignStatus;
	private Integer statusId;
	private Integer utitlizedHours;
	
	public Integer getTaskUserId() {
		return taskUserId;
	}
	public void setTaskUserId(Integer taskUserId) {
		this.taskUserId = taskUserId;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public Integer getAssignStatus() {
		return assignStatus;
	}
	public void setAssignStatus(Integer assignStatus) {
		this.assignStatus = assignStatus;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Integer getUtitlizedHours() {
		return utitlizedHours;
	}
	public void setUtitlizedHours(Integer utitlizedHours) {
		this.utitlizedHours = utitlizedHours;
	}
	
	
	

}
