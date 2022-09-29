package com.myproject.usecase;

import java.util.List;

import com.myproject.bean.Project;
import com.myproject.dao.ProjectDAO;
import com.myproject.dao.ProjectDAOImpl;

public class ViewAllProject {
	
	public static void main(String[] args) {
		
		ProjectDAO pO = new ProjectDAOImpl();
		
		
		List<Project> list =  pO.viewAllProjects();
		
		list.forEach(p->System.out.println(p));
		 
	}
}
