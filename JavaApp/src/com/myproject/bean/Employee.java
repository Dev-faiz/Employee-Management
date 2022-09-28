package com.myproject.bean;

public class Employee {
	int empId ; 
	String empName ; 
	String empGender ; 
	int empWage ; 
	String empDuty  ;
	String projAssigned ; 
	String GpoAssigned ;
	
	
	
	
	
	public Employee(String empName, String empGender, int empWage, String empDuty, String projAssigned,
			String gpoAssigned) {
		super();
		this.empName = empName;
		this.empGender = empGender;
		this.empWage = empWage;
		this.empDuty = empDuty;
		this.projAssigned = projAssigned;
		this.GpoAssigned = gpoAssigned;
	}
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public int getEmpWage() {
		return empWage;
	}
	public void setEmpWage(int empWage) {
		this.empWage = empWage;
	}
	public String getEmpDuty() {
		return empDuty;
	}
	public void setEmpDuty(String empDuty) {
		this.empDuty = empDuty;
	}
	public String getProjAssigned() {
		return projAssigned;
	}
	public void setProjAssigned(String projAssigned) {
		this.projAssigned = projAssigned;
	}
	public String getGpoAssigned() {
		return GpoAssigned;
	}
	public void setGpoAssigned(String gpoAssigned) {
		GpoAssigned = gpoAssigned;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empGender=" + empGender + ", empWage=" + empWage
				+ ", empDuty=" + empDuty + ", projAssigned=" + projAssigned + ", GpoAssigned=" + GpoAssigned + "]";
	} 
	
	
	
}
