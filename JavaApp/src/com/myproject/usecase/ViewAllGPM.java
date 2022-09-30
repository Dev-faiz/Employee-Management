package com.myproject.usecase;

import java.sql.SQLException;
import java.util.Formatter;
import java.util.List;

import com.myproject.bean.GPM;
import com.myproject.dao.GPDAO;
import com.myproject.dao.GPDAOImpl;

public class ViewAllGPM {
	public static void main(String[] args) throws SQLException {
		
		GPDAO gpa = new GPDAOImpl();
		
		List<GPM> gpm = gpa.viewAllGPM();
		Formatter f = new Formatter();
		f.format("%15s %15s %15s %15s %15s\n", "ID" , "gname" , "location" , "username" , "password");
		System.out.println(f);
		gpm.forEach(g->System.out.println(g.forString()));

	}
}
