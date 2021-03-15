package com.mycompany;

import java.sql.*;
import java.io.IOException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;

import java.util.Hashtable;

public class DBConnect{ 
	
	public  Connection con; 
	public  Statement stm; 
	private String sit = ""; 
    private DataSource ds;
    private ResultSet res;
	
    private String datasource_name = "H2_784_JNDI";
    
	public DBConnect() { 
		
		Hashtable env = new Hashtable();
	    env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
	    
	    try {
	    	// Get a Connection to the database
	    	Context context = new InitialContext(env);
	        ds = (DataSource) context.lookup ("java:jboss/datasources/H2_784_JNDI");
	        con = ds.getConnection();
	        stm = con.createStatement(); 
	        sit = "Connection successfully executed"; 
	              	       
	    } catch(Exception e) {
	            e.printStackTrace();
	            sit = "Could not connect to the database" + e.getMessage();
		} 
	}  // end of DBConnect constructor
	 
	
	public ResultSet getRegistrar() { 
		try {

			res = stm.executeQuery("select * from Registrar;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res; 
	} 	
	
}