package com.myproject.dao;

import java.sql.SQLException;

import com.myproject.bean.Project;
import com.myproject.exception.ProjectException;

public interface ProjectDAO {
	
	public String addProject(Project p) throws ProjectException , SQLException ;  
}
