package com.myproject.usecase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.myproject.dao.EmployeeDAO;
import com.myproject.dao.EmployeeDAOImpl;
import com.myproject.exception.EmployeeException;
import com.myproject.util.Console;
import com.myproject.util.DBConnect;

public class AssignEmpToProject {
	public static void main(String user) throws EmployeeException, SQLException {
		
		Scanner in = new Scanner(System.in);
		
			System.out.println(Console.CYAN+"Enter Details");
			
			System.out.println("Enter Project Name ");
			
			String pname = in.next();
			
			boolean checkThefuckingPname = check(pname);
			
			String gname = getThefuckingGname(user);
			
			System.out.println("Enter EmpId");
			
			int id = in.nextInt();
			
			System.out.println("Enter EmpName");
			
			String empName = in.next();
			
			
			
			EmployeeDAO emdao = new EmployeeDAOImpl();
			
			if(checkThefuckingPname) {
				String m = emdao.assignProjToEmp(pname, id, empName , gname);
				System.out.println(Console.RESET+Console.GREEN+m+Console.RESET);
			}else {
				System.out.println(Console.RED_BACKGROUND+"Please Enter valid project Name"+Console.RESET);
			}
			
			
			
			
	}

	private static boolean check(String pname) throws SQLException {
		boolean flag = false ;
		try(Connection c = DBConnect.getConnected()){
					
					PreparedStatement ps = c.prepareStatement("select pname from projects where pname = ?");
					
					ps.setString(1, pname);
					
					ResultSet rs = ps.executeQuery();
					
					if(rs.next()) {
						 flag = true ; 
					}
				}
		return flag ;
	}

	private static String getThefuckingGname(String user) throws SQLException {
		String m = null ;
		try(Connection c = DBConnect.getConnected()){
			
			PreparedStatement ps = c.prepareStatement("select gname from grampanchayatmember where username = ?");
			
			ps.setString(1, user);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				 m = rs.getString("gname");
			}
		}
		
		return m ;
	}
}
