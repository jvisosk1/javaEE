package com.mycompany;

import java.sql.*;
import java.io.IOException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;

import java.util.Hashtable;

public class DBConnection{ 
	
	public  Connection con; 
	public  Statement stm; 
	public  Statement stm1; 
	private String sit = ""; 
    private DataSource ds;
    public ResultSet res;
	
    private String datasource_name = "H2_784_JNDI";
    
	public DBConnection() { 
		
		Hashtable env = new Hashtable();
	    env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
	    
	    try {
	    	// Get a Connection to the database
	    	Context context = new InitialContext(env);
	        ds = (DataSource) context.lookup ("java:jboss/datasources/" + datasource_name);
	        con = ds.getConnection();
	        stm = con.createStatement(); 
	        sit = "Connection successfully executed"; 
	              	       
	    } catch(Exception e) {
	            e.printStackTrace();
	            sit = "Could not connect to the database" + e.getMessage();
		} 
	}  // end of DBConnection constructor
	
	public String getSituation(){ 
		return sit; 
	} 
	 
	public void insertStudent(String userid, String pw, String fname, String lname, 
			String ssn, String email, String address) { 
		try { 
			stm.executeUpdate("insert into STUDENT (userid, password, fname, lname, ssn, email, address) values" 
			+ " ('" + userid + "', '" + pw + "', '" + fname + "', '" + lname + "', '" + ssn + "', '" + email + "', '" + address + "' );");  			
		} catch (SQLException e){ 
			e.printStackTrace(); 
		}
	} 
	 
	public ResultSet getStudents() { 
		try {
			res = stm.executeQuery("SELECT * FROM Student;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res; 
	} 	
	
	public ResultSet getCourses() { 
		try {

			res = stm.executeQuery("SELECT DISTINCT Courses.course_id, Courses.course_title, Registrar.num_registered FROM Courses COURSES INNER JOIN Registrar ON Courses.course_id = Registrar.course_id ORDER BY Courses.course_id;;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res; 
	} 	
	
	public ResultSet getRegistrar() { 
		try {

			res = stm.executeQuery("select * from Registrar;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res; 
	} 	
	
	public int increaseEnrolledNum(int course_capacity, String course_id) { 
		int students_enrolled = 0;
		try {
			res = stm.executeQuery("SELECT * FROM Registrar WHERE course_id = '" + course_id + "';");
			String courseID;
			res.next();
			courseID = res.getString("course_id");
			students_enrolled = res.getInt("num_registered");
			if(students_enrolled < course_capacity) {
				stm.executeUpdate("UPDATE Registrar SET num_registered = num_registered + 1 WHERE course_id = '" + course_id + "';");
				students_enrolled++;
			} else students_enrolled = -1;
			
//			stm.executeUpdate("UPDATE Registrar SET num_registered = 0;");
//			stm.executeUpdate("UPDATE Registrar SET num_registered = CASE WHEN num_registered < " + course_capacity + " THEN "
//					+ "num_registered + 1 ELSE num_registered END WHERE course_id = '" + course_id + "';");
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students_enrolled; 
	}
	
}