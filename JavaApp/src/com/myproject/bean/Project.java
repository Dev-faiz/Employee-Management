package com.myproject.bean;

public class Project {
	int projectId ; 
	String projectName ; 
	String location ; 
	
	public Project() {
		
	}
	public Project(String pn , String l) {
		
		this.projectName = pn ;
		this.location = l ;
		
	}
	public Project(int id, String name, String loc) {
		this.projectId = id ; 
		this.projectName = name ;
		this.location = loc ;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", location=" + location + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
