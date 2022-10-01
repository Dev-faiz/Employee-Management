package com.myproject.usecase;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.myproject.bean.Employee;
import com.myproject.dao.EmployeeDAO;
import com.myproject.dao.EmployeeDAOImpl;
import com.myproject.exception.EmployeeException;
import com.myproject.util.Console;

public class FindEmp {
	
	public static void main() throws EmployeeException, SQLException {
		
		
		
		try {
			
			Scanner in = new Scanner(System.in);
			
			System.out.println(Console.CYAN+"Enter the Name of Employee");
			String name = in.next();
			
			System.out.println("Enter Employees Id ");
			int id = in.nextInt();
			
			
			EmployeeDAO ed = new EmployeeDAOImpl();
			Employee e  = ed.checkEmployee(name, id);
			if(e == null) {
				System.out.println(Console.WHITE_BOLD+Console.RED_BACKGROUND+"Employee with name "+name +" and Id "+id+" doesNot Exist"+Console.RESET);
			}else {
				System.out.println(Console.RESET+Console.GREEN+e+Console.RESET);
			}
		}catch(InputMismatchException ee){
			System.out.println(Console.RED+"Please Id Must be Number"+Console.RESET);
			
		}
	}
	
}
