package com.myproject.dao;

import java.sql.SQLException;
import java.util.List;

import com.myproject.bean.Employee;
import com.myproject.exception.EmployeeException;

public interface EmployeeDAO  {

	public String addEmployee(Employee e) throws EmployeeException , SQLException ; 
	
	public  boolean backEndUserCheck(String username ,String password) throws SQLException ;
	
	public  boolean GPOUserCheck(String username ,String password) throws SQLException ;
	public List<String> viewEmpByProjectName(String proj) throws SQLException; 
	
	public Employee checkEmployee(String empN, int id) throws EmployeeException , SQLException ;
	
	
	
	public List<String> checkWageByProject(String projName) throws EmployeeException , SQLException ;
		
		
		
	
	
}