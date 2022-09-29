package com.myproject.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.myproject.dao.EmployeeDAO;
import com.myproject.dao.EmployeeDAOImpl;
import com.myproject.dao.ProjectDAO;
import com.myproject.dao.ProjectDAOImpl;
import com.myproject.exception.GPException;
import com.myproject.exception.ProjectException;
import com.myproject.usecase.AddGPM;
import com.myproject.usecase.AddProject;
import com.myproject.usecase.AllocateProjectToGPM;
import com.myproject.usecase.ViewAllGPM;
import com.myproject.usecase.ViewAllProject;

public class Main {
	
	public static void main(String[] args) throws SQLException, ProjectException, GPException {
		
		
		System.out.println("Welcome to MGNREGA");
		System.out.println("Press 1 to Login as Backend Developer");
		System.out.println("Press 2 to Login as Gram Panchayat Member");
		
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		
		while(true) {
			
			if(choice == 1 ) {
				System.out.println("Enter UserName");
				String username = in.next();
				
				System.out.println("Enter Password");
					
				String password = in.next();
				EmployeeDAO edao = new EmployeeDAOImpl();
			
/////////////////////////////////////////////////////////////////////////////////////////////
//				BackEndDevChoice 
					if(edao.backEndUserCheck(username, password)) {
						System.out.println("Sucessfully LoggedIn");
						System.out.println("Please Select Queries which you want to Apply ");
						
						System.out.println("Press 1 to create New Project");
						System.out.println("Press 2 to watch all Project");
						System.out.println("Press 3 to Create new GramPanchayat Members");
						System.out.println("Press 4 to Watch all GramPanchayat Members");
						System.out.println("Press 5 to Allocate Project to GramPanchayatMember");
						System.out.println("Press 6 to see all the list of employee working on Project");
						int BODQ =  in.nextInt();
						
						switch(BODQ) {
							
							case 1 : AddProject.main(args);
								break ;
							
							case 2 : ViewAllProject.main(args);
								break ;
							
							case 3 : AddGPM.main(args);
								break ;
							
							case 4 : ViewAllGPM.main(args);
								break;
							
							case 5 : AllocateProjectToGPM.main(args);
								break ;
								
							case 6 : 
							
						}
						break ; 
						
						
					}else {
						
						
						System.out.println("Please Check Credentials");
					}

				}
			
///////////////////////////////////////////////////////////////////////////////////////////
//			GramPanchayat Memeber
			if(choice == 2) {
				
				
				
				
			}
				
			}

		}
		
		
		
		
		
		
		
		
	}

