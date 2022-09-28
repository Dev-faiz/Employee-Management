package com.myproject.dao;
import java.sql.SQLException;

import com.myproject.bean.GPM;
import com.myproject.exception.GPException;

public interface GPDAO {
	
	public String AddnewGPMemeber(GPM gmp) throws SQLException ,GPException;
	
}