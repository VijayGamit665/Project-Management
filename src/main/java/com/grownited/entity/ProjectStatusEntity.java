package com.grownited.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "statusEntity")
public class ProjectStatusEntity {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer projectId;
	public String project;
	public String title;
	public String description;
	public Integer projectStatusId;
	public String docURL;
	public String estimatedHours;
	public String totalUtilizedHours;
	public String projectStartDate;
	public String projectCompletionDate;

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getProjectStatusId() {
		return projectStatusId;
	}

	public void setProjectStatusId(Integer projectStatusId) {
		this.projectStatusId = projectStatusId;
	}

	public String getDocURL() {
		return docURL;
	}

	public void setDocURL(String docURL) {
		this.docURL = docURL;
	}

	public String getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(String estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public String getTotalUtilizedHours() {
		return totalUtilizedHours;
	}

	public void setTotalUtilizedHours(String totalUtilizedHours) {
		this.totalUtilizedHours = totalUtilizedHours;
	}

	public String getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public String getProjectCompletionDate() {
		return projectCompletionDate;
	}

	public void setProjectCompletionDate(String projectCompletionDate) {
		this.projectCompletionDate = projectCompletionDate;
	}

}
