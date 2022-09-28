package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myproject.bean.GPM;
import com.myproject.exception.GPException;
import com.myproject.util.DBConnect;

public  class GPDAOImpl implements GPDAO {

	@Override
	public String AddnewGPMemeber(GPM gmp) throws SQLException , GPException {
		
		String m = null; 
		
		try(Connection c = DBConnect.getConnected()){
			
		PreparedStatement ps = c.prepareStatement("insert into  grampanchayatmember(Gname,Location,username,passworde) "+ "values(?,?,?,?);");
		
			ps.setString(1, gmp.getGname());
			ps.setString(2, gmp.getLocation());
			ps.setString(3, gmp.getUsername());
			ps.setString(4, gmp.getPassword());
			
			int ex = ps.executeUpdate() ; 
			
			if(ex > 0 ) {
				
				m = "Values are Added Sucessfully" ;
			}else {
				
				throw new GPException("Values are not added Successfully");
				
			}
			c.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
//			System.out.println(e.getStackTrace());
		}
		
		

		return m;
	}


}
