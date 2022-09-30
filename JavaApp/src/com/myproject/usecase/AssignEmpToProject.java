package com.myproject.usecase;

import java.sql.SQLException;
import java.util.Scanner;

import com.myproject.dao.EmployeeDAO;
import com.myproject.dao.EmployeeDAOImpl;
import com.myproject.exception.EmployeeException;

public class AssignEmpToProject {
	public static void main() throws EmployeeException, SQLException {
		
		Scanner in = new Scanner(System.in);
		
			System.out.println("Enter Details");
			
			System.out.println("Enter Project Name ");
			
			String pname = in.next();
			
			System.out.println("Enter EmpId");
			
			int id = in.nextInt();
			
			System.out.println("Enter EmpName");
			
			String empName = in.next();
			
			
			EmployeeDAO emdao = new EmployeeDAOImpl();
			
			String m = emdao.assignProjToEmp(pname, id, empName);
			
			System.out.println(m);
	}
}
