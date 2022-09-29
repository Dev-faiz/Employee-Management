package com.myproject.usecase;

import java.sql.SQLException;
import java.util.List;

import com.myproject.bean.GPM;
import com.myproject.dao.GPDAO;
import com.myproject.dao.GPDAOImpl;

public class ViewAllGPM {
	public static void main(String[] args) throws SQLException {
		
		GPDAO gpa = new GPDAOImpl();
		
		List<GPM> gpm = gpa.viewAllGPM();
		
		gpm.forEach(g->System.out.println(g));

	}
}
