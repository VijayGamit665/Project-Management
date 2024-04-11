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
	private Integer userId;
	private Integer taskId;
	private Integer assignStatus;
	private Integer projectStatusId;
	private Integer utitlizedHours;
	private Integer moduleId;
	
	public Integer getTaskUserId() {
		return taskUserId;
	}
	public void setTaskUserId(Integer taskUserId) {
		this.taskUserId = taskUserId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public Integer getProjectStatusId() {
		return projectStatusId;
	}
	public void setProjectStatusId(Integer projectStatusId) {
		this.projectStatusId = projectStatusId;
	}
	public Integer getUtitlizedHours() {
		return utitlizedHours;
	}
	public void setUtitlizedHours(Integer utitlizedHours) {
		this.utitlizedHours = utitlizedHours;
	}
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	
}
