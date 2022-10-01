package com.myproject.usecase;

import java.sql.SQLException;
import java.util.Formatter;
import java.util.List;

import com.myproject.bean.GPM;
import com.myproject.dao.GPDAO;
import com.myproject.dao.GPDAOImpl;
import com.myproject.util.Console;

public class ViewAllGPM {
	public static void main() throws SQLException {
		
		GPDAO gpa = new GPDAOImpl();
//		System.out.printf("%50s %50s\n","faiz","don");
		List<GPM> gpm = gpa.viewAllGPM();
		Formatter f = new Formatter();
		System.out.println(Console.BLACK_BOLD+"=========================================================================================");
		f.format("%15s %15s %15s %15s %15s\n", "ID" , "gname" , "location" , "username" , "password");
		System.out.println(f);
		gpm.forEach(g->System.out.println(g.forString()));
		System.out.println("==================================================================================================================="+Console.RESET);
	}
}
