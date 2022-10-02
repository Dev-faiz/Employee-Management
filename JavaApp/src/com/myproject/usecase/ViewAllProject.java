package com.myproject.usecase;

import java.util.Formatter;
import java.util.List;

import com.myproject.bean.Project;
import com.myproject.dao.ProjectDAO;
import com.myproject.dao.ProjectDAOImpl;
import com.myproject.util.Console;

public class ViewAllProject {
	
	public static void main() {
		
		ProjectDAO pO = new ProjectDAOImpl();
		
		Formatter fmt = new Formatter();
		System.out.println(Console.BLACK_BOLD+"===========================================================================================");
		fmt.format("%22s %30s %22s\n", "|  ProjectNo  |","  |  ProjectName  |  ", "  |  Location  |");
		System.out.println(fmt);
		
		
		List<Project> list =  pO.viewAllProjects();
		
//		System.out.println("ProjectNo");
		list.forEach(p->System.out.println(p.forString()));
		System.out.println("==========================================================================================="+Console.RESET);
		
		
		 
	}
}
