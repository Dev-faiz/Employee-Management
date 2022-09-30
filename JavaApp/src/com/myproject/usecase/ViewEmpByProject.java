package com.myproject.usecase;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.myproject.dao.EmployeeDAO;
import com.myproject.dao.EmployeeDAOImpl;


public class ViewEmpByProject {
	
	public static void main() throws SQLException {
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Add details");
		String x = in.nextLine();
		EmployeeDAO pd = new EmployeeDAOImpl();
		
		List<String> l = pd.viewEmpByProjectName(x);
//		System.out.println(l);
		
//		in.close();
	}
}
