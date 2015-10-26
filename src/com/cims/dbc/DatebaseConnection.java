package com.cims.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class DatebaseConnection {
	private static final String DSNAME = "java:comp/env/jdbc/cimsdb";
	private Connection conn = null;
	
	public DatebaseConnection() throws Exception{
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup(DSNAME);
			
			this.conn = ds.getConnection();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	public void close(){
		if(this.conn != null){
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
