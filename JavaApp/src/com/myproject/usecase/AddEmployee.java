package com.myproject.usecase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;
import com.myproject.bean.Employee;
import com.myproject.bean.GPM;
import com.myproject.bean.Project;
import com.myproject.dao.EmployeeDAO;
import com.myproject.dao.EmployeeDAOImpl;
import com.myproject.exception.EmployeeException;
import com.myproject.util.Console;
import com.myproject.util.DBConnect;

public class AddEmployee {
	
	public static void main2() throws SQLException, EmployeeException{
		
		Scanner in = new Scanner(System.in);
		
		System.out.println(Console.CYAN+"Enter Name of Empolyee");
		String ename = 	in.nextLine();
		
		
		System.out.println("Enter Gender (M/F)");
		String gender = in.nextLine();
		
		System.out.println("Enter wage of Employee per day");
		int wage = in.nextInt();
		
		System.out.println("Enter number of days Employee is given service"+Console.RESET);
		int day = in.nextInt();
		
		EmployeeDAO ed = new EmployeeDAOImpl();
		String m =	ed.addEmployee(new Employee(ename , gender , wage , day ));	
		System.out.println(Console.GREEN+m+Console.RESET);
		
	}
	
	
	public static void main() throws SQLException, EmployeeException {
		
		Scanner in = new Scanner(System.in);
		
		
		
		System.out.println("Enter Name of Empolyee");
		String ename = 	in.nextLine();
		
		
		System.out.println("Enter Gender (M/F)");
		String gender = in.nextLine();
		
		System.out.println("EnterGPO Name");
		String x =	in.nextLine();
		int gId =  getGPOId(x);
		
		System.out.println("Enter Name of Project");		
		String nameOfP = in.nextLine();
		int pId = getProjectId(nameOfP);
		
		System.out.println("Enter wage of Employee per day");
		int wage = in.nextInt();
		
		System.out.println("Enter number of days Employee is given service");
		int day = in.nextInt();
		
		
		
	
		
		EmployeeDAO ed = new EmployeeDAOImpl();
		String m =	ed.addEmployee(new Employee(ename , gender , wage , day ,gId , pId));
//		
		System.out.println(m);
//		in.close();
			

		
	}

	private static int getProjectId(String nameOfP) throws SQLException, EmployeeException {
			Project p = new Project();
			try(Connection c = DBConnect.getConnected()){
				
				PreparedStatement ps = c.prepareStatement("select * from projects where PName = ?");
			
				ps.setString(1, nameOfP);

				ResultSet q =  ps.executeQuery();
				
			if(q.next()) {
				
				int id = q.getInt("ProjectNo");
				
					p.setProjectId(id);;

				}
					
			}
			return p.getProjectId() ; 
			
	}

	private static int getGPOId(String name) throws SQLException, EmployeeException  {
			GPM gpm = new GPM();
		try(Connection c = DBConnect.getConnected()){
			
			PreparedStatement ps = c.prepareStatement("select * from grampanchayatmember where gname = ?");
			
			ps.setString(1, name);

			ResultSet q =  ps.executeQuery();
			
		if(q.next()) {
			
			int id = q.getInt("ID");
			
			
				gpm.setID(id);
			
			
			}
				
		}
		return gpm.getID() ; 
	}
	
	
	
}
