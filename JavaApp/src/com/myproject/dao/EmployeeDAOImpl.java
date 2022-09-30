package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import com.myproject.bean.BackEndDev;
import com.myproject.bean.Employee;
import com.myproject.bean.GPM;
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
			
			PreparedStatement ps = c.prepareStatement(" select  e.empname ,g.gname, e.empwage , e.empdutyday  ,e.empwage*e.empdutyday as totalWage from projects p inner join employee e inner join grampanchayatmember g on pname = ? and e.projAssigned = p.projectNo and e.gpoAssigned = g.id; ;");
			
			ps.setString(1, proj);
			
		 ResultSet rs =	ps.executeQuery();
		 Formatter fmt = new Formatter();  
		 
		 fmt.format("%10s %12s %9s %10s %12s\n","EmpName "," GPMName ","EmpWage","EmpDays","TotalWage");
		
		 while(rs.next()) {
			String a = rs.getString("e.empname");
			String b = rs.getString("g.gname");
			int d = rs.getInt("e.empwage");
			int e = rs.getInt("e.empdutyday");
			int f = rs.getInt("totalWage");
			fmt.format("%10s %10s %10s %10s %10s\n", a , b ,d,e,f);
			
			 
		 }
		 System.out.println(fmt);
		}
		
		
//		 select  empname ,gname, empwage , empdutyday  ,empwage*empdutyday as totalWage from projects inner join employee inner join grampanchayatmember on pname = 'road construction'	
		
		
		return l;
	}

	public  boolean GPOUserCheck(String username ,String password) throws SQLException {
		GPM bed = new GPM();
		try(Connection c = DBConnect.getConnected()){
			
			PreparedStatement ps = c.prepareStatement("select * from grampanchayatmember where username = ? AND password = ?");
//			 select * from grampanchayatmember where username = 'efzi' and password = '8080'
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
	public Employee checkEmployee(String empN , int id) throws EmployeeException, SQLException {
		
		Employee em = null;
		
		try(Connection c = DBConnect.getConnected()){
			
			
			PreparedStatement ps = c.prepareStatement("select * from employee where EmpName = ? and EmpId = ?");
			
			
			ps.setString(1, empN);
			ps.setInt(2, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int idd = rs.getInt("EmpId");
				
				String n = rs.getString("EmpName");
				
				String g = rs.getString("EmpGender");
				
				int wage = rs.getInt("EmpWage");
				
				int duty = rs.getInt("EmpDutyDay");
				
				int pa = rs.getInt("ProjAssigned");
				
				int ga = rs.getInt("GPOAssigned");
				
				em = new Employee(idd, n, g, wage, duty,pa, ga);
				
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return em;
	}

	@Override
	public List<String> checkWageByProject(String projName) throws EmployeeException, SQLException {
		
//		List<String> l = new ArrayList<>();
		
		
		try(Connection c = DBConnect.getConnected()){
			
			
			PreparedStatement ps = c.prepareStatement("select empId , empName,empdutyday ,empdutyday * empwage as total from employee where projAssigned = (select ProjectNo from projects where pname = ? ) ;");
			
			ps.setString(1, projName);
			ResultSet rs = ps.executeQuery();
				Formatter f = new Formatter();
				Formatter e = new Formatter();
				f.format("%20s %20s %20s %20s\n", "EmpId","EmpName","EmpWorkingDay","Toale");
				System.out.println(f);
			while(rs.next()) {
				
				int id = rs.getInt("empId");
				String name = rs.getString("empName");
				int dd = rs.getInt("empdutyday");
				int to = rs.getInt("total");
				e.format("%20s %20s %20s %20s\n", id,name,dd,to);
				System.out.println(e);
			}
		}catch(SQLException e ) {
			
			
			System.out.println(e.getMessage());
			
		}
		
		return null;
	}

	@Override
	public String assignProjToEmp(String pname, int id , String ename) throws EmployeeException, SQLException {
		String message = "Error in Assigning" ;
		
		
		try(Connection c = DBConnect.getConnected()){
			
			PreparedStatement  ps = c.prepareStatement("update employee set projAssigned = (select ProjectNo from projects where pname = ?) where empId = ? and empname = ?");
			
			ps.setString(1, pname);
			ps.setInt(2, id);
			ps.setString(3, ename);
			
			int n = ps.executeUpdate();
			
			if(n > 0) {
				message = "Updated Successfully";
			}
		}catch(SQLException e) {
			
			
			
		}
		
		return message;
	}

	
	
	@Override
	public String addEmloyee1(Employee e) throws EmployeeException, SQLException {
		String message = "Employee is not added" ;
		
		try(Connection c = DBConnect.getConnected()){
			
			PreparedStatement ps = c.prepareStatement("into employee(EmpName,EmpGender,EmpWage,EmpDutyDay) values(?,?,?,?);");
				
				ps.setString(1, e.getEmpName());
				ps.setString(2, e.getEmpGender());
				ps.setInt(3, e.getEmpWage());
				ps.setInt(4, e.getEmpDuty());
				
				
				int n =  ps.executeUpdate();
				
				if(n > 0) {
					
					message = "Employee Added" ;
					
				}
				
			
		}catch(SQLException ex) {
			
			System.out.println(ex.getMessage());
		}
		
		
		return null;
	}
	
	
}
