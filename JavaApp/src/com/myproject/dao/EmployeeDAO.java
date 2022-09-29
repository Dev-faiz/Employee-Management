package com.myproject.dao;

import java.sql.SQLException;
import java.util.List;

import com.myproject.bean.Employee;
import com.myproject.exception.EmployeeException;

public interface EmployeeDAO  {

	public String addEmployee(Employee e) throws EmployeeException , SQLException ; 
	
	public  boolean backEndUserCheck(String username ,String password) throws SQLException ;
	
	
	public List<String> viewEmpByProjectName(String proj) throws SQLException; 
	
}