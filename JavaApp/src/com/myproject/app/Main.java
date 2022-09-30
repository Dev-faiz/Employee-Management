package com.myproject.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.myproject.dao.EmployeeDAO;
import com.myproject.dao.EmployeeDAOImpl;
import com.myproject.dao.ProjectDAO;
import com.myproject.dao.ProjectDAOImpl;
import com.myproject.exception.EmployeeException;
import com.myproject.exception.GPException;
import com.myproject.exception.ProjectException;
import com.myproject.usecase.AddEmployee;
import com.myproject.usecase.AddGPM;
import com.myproject.usecase.AddProject;
import com.myproject.usecase.AllocateProjectToGPM;
import com.myproject.usecase.AssignEmpToProject;
import com.myproject.usecase.FindEmp;
import com.myproject.usecase.ViewAllGPM;
import com.myproject.usecase.ViewAllProject;
import com.myproject.usecase.ViewEmpByProject;

public class Main {
	
	public static void main(String[] args) throws SQLException, ProjectException, GPException, EmployeeException {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to MGNREGA");
		System.out.println("Press 1 to Login as Backend Developer");
		System.out.println("Press 2 to Login as Gram Panchayat Member");
		int choice = in.nextInt();
		
		if(choice == 1) {
			System.out.println("Enter UserName");
			String username = in.next();
			
			System.out.println("Enter Password");	
			String password = in.next();
			
			EmployeeDAO edao = new EmployeeDAOImpl();
			
			boolean flag = edao.backEndUserCheck(username, password);
			if(flag == false ) {
				
				System.err.println("UserName or Password is wrong please try Again");
				
			}else {
				
				System.out.println("Sucessfully LoggedIn");
			}
			while(flag) {
				if(choice == 1 ) {
					boolean flag1 = true ;
					   while(flag1) {
							System.out.println("---------------------------------------------------------------------");
							
							System.out.println("Please Select Queries which you want to Apply ");
							System.out.println("Press 1 to create New Project");
							System.out.println("Press 2 to watch all Project");
							System.out.println("Press 3 to Create new GramPanchayat Members");
							System.out.println("Press 4 to Watch all GramPanchayat Members");
							System.out.println("Press 5 to Allocate Project to GramPanchayatMember");
							System.out.println("Press 6 to see all the list of employee working on Project");
							System.out.println("Press 7 to Exit");
							System.out.println("---------------------------------------------------------------------");
							int BODQ =  in.nextInt();
							
							switch(BODQ) {
								
								case 1 : AddProject.main();
									break ;
								case 2 : ViewAllProject.main();
									break ;
								case 3 : AddGPM.main();
									break ;
								case 4 : ViewAllGPM.main();
									break;
								case 5 : AllocateProjectToGPM.main();
									break ;
								case 6 : ViewEmpByProject.main();
									break;
								case 7 : System.exit(0); ;
									break ;	
							}
							break ; 
						}

					}
				}
		}
	
///////////////////////////////////////////////////////////////////////////////////////////
//---------------------------------------GramPanchayat Member-------------------------------
		
		if(choice == 2) {
			System.out.println("Enter UserName");
			String username = in.next();
			
			System.out.println("Enter Password");	
			String password = in.next();
			
			EmployeeDAO edao = new EmployeeDAOImpl();
			boolean flag =  edao.GPOUserCheck(username, password);
			if(flag == false) {
				System.err.println("UserName or Password is wrong please try Again");
			}else {
				System.out.println("Successfully Logged In ");
			}
			while(flag) {
				
			
				System.out.println("Press 1 Create Employee");
				System.out.println("Press 2 to View details of employee");
				System.out.println("Press 3 to Assign a project to existing employee");
				System.out.println("Press 4 View total number of days Employee worked in a project and also their wages");
				System.out.println("Press 5 for EXIT");
				int query = in.nextInt();
				
				switch(query) {
				
					case 1 : AddEmployee.main2();
						break ;
						
					case 2 : FindEmp.main();
						break;
					
					case 3 : AssignEmpToProject.main();
						break ;
					
					case 4 : ViewEmpByProject.main();
						break ;
						
					case 5 : System.exit(0);
						break;
				}
			}
			
			
		}

	}

}

