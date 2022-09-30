package com.myproject.usecase;

import java.util.Formatter;
import java.util.List;

import com.myproject.bean.Project;
import com.myproject.dao.ProjectDAO;
import com.myproject.dao.ProjectDAOImpl;

public class ViewAllProject {
	
	public static void main() {
		
		ProjectDAO pO = new ProjectDAOImpl();
		
		Formatter fmt = new Formatter();
		fmt.format("%20s %20s %20s\n", "ProjectNo","ProjectName", "Location");
		System.out.println(fmt);
		List<Project> list =  pO.viewAllProjects();
		
//		System.out.println("ProjectNo");
		list.forEach(p->System.out.println(p.forString()));
		
		
		 
	}
}
