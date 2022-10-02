package com.myproject.app;


import java.sql.SQLException;
import java.util.InputMismatchException;
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
import com.myproject.util.Console;

public class Main {
	
	public static void main(String[] args) throws SQLException, ProjectException, GPException, EmployeeException, InputMismatchException {
		int choice = 0 ; 
		Scanner in = new Scanner(System.in); 
		System.out.println(Console.WHITE);
		System.out.println(Console.GREEN_BACKGROUND+ "           Welcome to MGNREGA          "+ Console.RESET );
		System.out.println(Console.BROWN+"      Press 1 to Login as Backend Developer");
		System.out.println(Console.BROWN+"      Press 2 to Login as Gram Panchayat Member" + Console.RESET);
		System.out.println(Console.BROWN+"      Press 3 to Login Exit" + Console.RESET);
		try {
			
			 choice = in.nextInt();
		}catch(InputMismatchException e) {
			System.out.println(Console.RED_BACKGROUND+"Enter Valid Number"+Console.RESET);
		}
		
		if(choice == 1) {
			System.out.println(Console.BLUE+"Enter UserName");
			String username = in.next();
			
			System.out.println("Enter Password"+Console.RESET);	
			String password = in.next();
			
			EmployeeDAO edao = new EmployeeDAOImpl();
			
			boolean flag = edao.backEndUserCheck(username, password);
			if(flag == false ) {
				
				System.out.println(Console.RED_BACKGROUND+"UserName or Password is wrong please try Again"+Console.RESET);
				Main.main(args);
				
			}else {
				
				System.out.println(Console.FOREST_GREEN+"Sucessfully LoggedIn"+Console.RESET);
			}
			while(flag) {
				if(choice == 1 ) {
					
					boolean flag1 = true ;
					   while(flag1) {
							System.out.println("---------------------------------------------------------------------");
							
							System.out.println(Console.PURPLE+"Please Select Queries which you want to Apply ");
							System.out.println("Press 1 to create New Project");
							System.out.println("Press 2 to watch all Project");
							System.out.println("Press 3 to Create new GramPanchayat Members");
							System.out.println("Press 4 to Watch all GramPanchayat Members");
							System.out.println("Press 5 to Allocate Project to GramPanchayatMember");
							System.out.println("Press 6 to see all the list of employee working on Project");
							System.out.println("Press 7 to Go Back to login page"+Console.RESET);
							System.out.println("Press 8 to Exit");
							System.out.println("---------------------------------------------------------------------");
							
							
							
							
								String BODQ =  in.next();
						
							
							
							
							switch(BODQ) {
								
								case "1" : AddProject.main();
									break ;
								case "2" : ViewAllProject.main();
									break ;
								case "3" : AddGPM.main();
									break ;
								case "4" : ViewAllGPM.main();
									break;
								case "5" : AllocateProjectToGPM.main();
									break ;
								case "6" : ViewEmpByProject.main();
									break;
								case "7" : Main.main(args); 
									break ;
								case "8" : System.exit(0);
							}
							break ; 
						}

					}
				}
		}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//---------------------------------------GramPanchayat Member--------------------------------------------------------
		
		else if(choice == 2) {
			System.out.println(Console.CYAN+"Enter UserName");
			String username = in.next();
			
			System.out.println("Enter Password");	
			String password = in.next();
			
			EmployeeDAO edao = new EmployeeDAOImpl();
			boolean flag =  edao.GPOUserCheck(username, password);
			if(flag == false) {
				System.err.println(Console.RED+"UserName or Password is wrong please try Again"+Console.RED);
				Main.main(args);
			}else {
				System.out.println(Console.RESET+Console.FOREST_GREEN+"Successfully Logged In "+Console.RESET);
			}
			while(flag) {
				
				System.out.println(Console.PURPLE+"Press 1 Create Employee");
				System.out.println("Press 2 to View details of employee");
				System.out.println("Press 3 to Assign a project to existing employee");
				System.out.println("Press 4 View total number of days Employee worked in a project and also their wages");
				System.out.println("Press 5 to Go back to login page");
				System.out.println("Press 6 for EXIT"+Console.RESET);
				String  query = in.next();
				
				switch(query) {
				
				
				case "1" : AddEmployee.main2();
						break ;
					case "2" : FindEmp.main();
						break;
					case "3" : AssignEmpToProject.main(username);
						break ;
					case "4" : ViewEmpByProject.main();
						break ;
					case "5" : Main.main(args);
						break ;
					case "6" : System.exit(0);
						break;
				}
			}
			
			
		}else if(choice == 3) {
			System.exit(0);
		}else {
			System.err.println("Please enter valid Choice");
			Main.main(args);
		}

	}

}

