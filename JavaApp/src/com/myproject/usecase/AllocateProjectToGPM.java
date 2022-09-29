package com.myproject.usecase;

import java.sql.SQLException;
import java.util.Scanner;

import com.myproject.dao.ProjectDAO;
import com.myproject.dao.ProjectDAOImpl;
import com.myproject.exception.ProjectException;

public class AllocateProjectToGPM {

		
		public static void main(String[] args) throws ProjectException, SQLException {
			
			Scanner in = new Scanner(System.in);
			System.out.println("Enter Name of Project");
			String pname = 	in.nextLine();
			
			System.out.println("Enter Name of Grampanchayat Member ");
			String gname = in.nextLine();
			
			ProjectDAO passign = new  ProjectDAOImpl() ;
			
			String m =  passign.allocateProjectToGPM(pname, gname);
			
			System.out.println(m);
			
			
			
			
		in.close();	
			
		
		
	}
}
