package com.myproject.usecase;

import java.sql.SQLException;
import java.util.Scanner;

import com.myproject.bean.Employee;
import com.myproject.dao.EmployeeDAO;
import com.myproject.dao.EmployeeDAOImpl;
import com.myproject.exception.EmployeeException;

public class FindEmp {
	
	public static void main(String[] args) throws EmployeeException, SQLException {
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the Name of Employee");
		String name = in.next();
		
		System.out.println("Enter Employees Id ");
		int id = in.nextInt();
		
		
		EmployeeDAO ed = new EmployeeDAOImpl();
		Employee e  = ed.checkEmployee(name, id);
		
		System.out.println(e);
		
	}
	
}
