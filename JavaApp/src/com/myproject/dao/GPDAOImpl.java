package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.bean.GPM;
import com.myproject.exception.GPException;
import com.myproject.util.Console;
import com.myproject.util.DBConnect;

public  class GPDAOImpl implements GPDAO {

	@Override
	public String AddnewGPMemeber(GPM gmp) throws SQLException , GPException {
		
		String m = Console.RED+"There is some error while adding"+Console.RESET; 
		
		try(Connection c = DBConnect.getConnected()){
			
		PreparedStatement ps = c.prepareStatement("insert into  grampanchayatmember(Gname,Location,username,password) "+ "values(?,?,?,?);");
		
			ps.setString(1, gmp.getGname());
			ps.setString(2, gmp.getLocation());
			ps.setString(3, gmp.getUsername());
			ps.setString(4, gmp.getPassword());
			
			int ex = ps.executeUpdate() ; 
			
			if(ex > 0 ) {
				
				m = Console.GREEN+"Values are Added Sucessfully"+Console.RESET ;
			}else {
				
				throw new GPException(Console.RED+"Values are not added Successfully"+Console.RESET);
				
			}
			c.close();
		}catch(SQLException e) {
			System.out.println(Console.RED+e.getMessage()+Console.RESET);

		}

		return m;
	}

	@Override
	public List<GPM> viewAllGPM() throws SQLException {
		
		
		List<GPM> list = new ArrayList<>();
		
		
		try(Connection c = DBConnect.getConnected()){
			
			PreparedStatement ps = c.prepareStatement("select * from grampanchayatmember");
			
			ResultSet rs =  ps.executeQuery();
			
			
			while(rs.next()) {
				
				int id = rs.getInt("ID");
				String name = rs.getString("Gname");
				String loc = rs.getString("Location");
				String usr = rs.getString("username");
				String pass = rs.getString("password");
				
				list.add(new GPM(id, name, loc, usr, pass));
				
			}
			
		}catch(SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		return list;
	}


}
