package com.grownited.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="module")
public class ModuleEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Integer moduleId;
	public String moduleName;
	public Integer projectId;
	public String status;
	public String description;
	public String docURL;
	public Integer estimatedHours;
	public Integer totalUtilizedHours;
	
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDocURL() {
		return docURL;
	}
	public void setDocURL(String docURL) {
		this.docURL = docURL;
	}
	public Integer getEstimatedHours() {
		return estimatedHours;
	}
	public void setEstimatedHours(Integer estimatedHours) {
		this.estimatedHours = estimatedHours;
	}
	public Integer getTotalUtilizedHours() {
		return totalUtilizedHours;
	}
	public void setTotalUtilizedHours(Integer totalUtilizedHours) {
		this.totalUtilizedHours = totalUtilizedHours;
	}
	
	

}
