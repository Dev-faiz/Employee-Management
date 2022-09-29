package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.bean.BackEndDev;
import com.myproject.bean.Employee;
import com.myproject.exception.EmployeeException;
import com.myproject.util.DBConnect;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public String addEmployee(Employee e) throws EmployeeException, SQLException {
		
		String message = "There is some error while adding new Employee " ;
		
		
		try(Connection c = DBConnect.getConnected()){
			
			PreparedStatement ps = c.prepareStatement("insert into Employee("
					+ "EmpName,EmpGender,EmpWage,EmpDutyDay,ProjAssigned,GPOAssigned)"
					+ "values(?,?,?,?,?,?)");
			
			
			ps.setString(1, e.getEmpName());
			ps.setString(2,e.getEmpGender());
			ps.setInt(3, e.getEmpWage());
			ps.setInt(4, e.getEmpDuty());
			ps.setInt(5, e.getProjAssigned());
			ps.setInt(6, e.getGpoAssigned());
			
			
		int update = 	ps.executeUpdate();	
		
		if(update > 0) {
			message = "Employee Added successfully";
		}else {
			throw new EmployeeException("Error in adding employee");
		}
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		
		return message;
	}

	
	@Override
	public boolean backEndUserCheck(String username, String password) throws SQLException {
		BackEndDev bed = new BackEndDev();
		try(Connection c = DBConnect.getConnected()){
			
			PreparedStatement ps = c.prepareStatement("select * from backenddev where username = ? AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
			String user = 	rs.getString("username");
			String pass = 	rs.getString("password");
				
			bed.setUsername(user);
			bed.setPassword(pass);
			return true ;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			return false;
		}
		
		
		
		
	}


	@Override
	public List<String> viewEmpByProjectName(String proj) throws SQLException {
		
		List<String> l = new ArrayList<>();
		

		try(Connection c = DBConnect.getConnected()){
			
			PreparedStatement ps = c.prepareStatement("select  empname , pname  ,empwage*empdutyday as totalWage from projects inner join employee on pname = ? ;");
			
			ps.setString(1, proj);
			
		 ResultSet rs =	ps.executeQuery();
		 
		 while(rs.next()) {
			 
			String a = rs.getString("empName");
			String b = rs.getString("pname");
			String d = rs.getString("totalWage");
			 
			 l.add(a);
			 l.add(b);
			 l.add(d);
			 
		 }
		}
		
		
		
		
		
		return l;
	}


	private int getAssignedID(String proj) {
		
		return 0;
	}

}
