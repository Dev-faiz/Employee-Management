


package com.myproject.usecase;

import java.sql.SQLException;
import java.util.Scanner;
import com.myproject.bean.Project;
import com.myproject.dao.ProjectDAO;
import com.myproject.dao.ProjectDAOImpl;
import com.myproject.exception.ProjectException;

public class AddProject {
	
	public static void main() throws ProjectException, SQLException {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Name of Project");
		String pname = 	in.nextLine();
		
		System.out.println("Enter Location Project ");
		String loc = in.nextLine();
		

		
		ProjectDAO newProject = new ProjectDAOImpl();
		
		String message  =  newProject.addProject(new Project(pname , loc));
		
		System.out.println(message);
//	in.close();	
		
	}
}
