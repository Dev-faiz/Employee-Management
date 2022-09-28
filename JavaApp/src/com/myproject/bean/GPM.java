package com.myproject.bean;

public class GPM {
	int ID  ; 
	String gname ; 
	String location ; 
	String username ; 
	String password ; 
	
	
	public GPM(String g , String loc ,String user , String pass) {
		
		this.gname = g ; 
		this.location = loc ; 
		this.username = user ; 
		this.password = pass ;
		
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getGname() {
		return gname;
	}


	public void setGname(String gname) {
		this.gname = gname;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "GPM [ID=" + ID + ", gname=" + gname + ", location=" + location + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
}
