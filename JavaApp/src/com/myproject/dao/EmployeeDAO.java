package com.myproject.dao;

import java.sql.SQLException;

import com.myproject.bean.Employee;
import com.myproject.exception.EmployeeException;

public interface EmployeeDAO  {

	public String addEmployee(Employee e) throws EmployeeException , SQLException ; 
}
