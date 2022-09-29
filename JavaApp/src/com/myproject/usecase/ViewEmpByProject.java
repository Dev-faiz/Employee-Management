package com.myproject.usecase;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.myproject.dao.EmployeeDAO;
import com.myproject.dao.EmployeeDAOImpl;


public class ViewEmpByProject {
	
	public static void main(String[] args) throws SQLException {
		
		
		Scanner in = new Scanner(System.in);
		
		String x = in.nextLine();
		System.out.println("fuck");
		EmployeeDAO pd = new EmployeeDAOImpl();
		
		List<String> l = pd.viewEmpByProjectName(x);
		l.forEach(e->System.out.println(e));
	}
}
