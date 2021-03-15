package com.mycompany;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import java.sql.*;

import javax.sql.DataSource;

import com.mycompany.DBConnection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class mvc_servlet
 */
@WebServlet("/login_servlet")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Boolean validateInput(TestBean testobj, String userid, String password) {
    	
    	Boolean errorsFound = false;
    	
    	if(userid.length() < 8 || userid.length() > 16 || password.length() < 8 || password.length() > 16) {
    		errorsFound = true;
    		testobj.setLoginErrorMsg("User ID and Passwords must be between 8-16 characters. ");
    	}
    	
    	if( !userid.matches("\\S+") || !password.matches("\\S+") ) {
			errorsFound = true;
			testobj.setLoginErrorMsg("User ID and Passwords may not contain blank spaces. ");
		}
    	
    	return errorsFound;
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	HttpSession session = request.getSession(true);

    	// IF NEW SESSION CREATE NEW JAVA BEAN, OTHERWISE USE EXISTING BEAN WITH DATA ALREADY SET
    	TestBean testobj;
		if (session.isNew()) {
    		testobj = new TestBean();
    		session.setAttribute("testobj", testobj);
    	}
        else {
	    	testobj = (TestBean)session.getAttribute("testobj");  
	    	testobj.attempts++;
        }
    	testobj.clearLoginErrorMsg();
    	
    	request.setAttribute("gurubean",testobj);
        RequestDispatcher rd = null;
        
    	if(testobj.attempts > 3) {
    		testobj.setLoginErrorMsg("Maximum login attempts reached. Login blocked.");
        	rd=request.getRequestDispatcher("login-error.jsp"); 
        	rd.forward(request, response);
        }
   		
//       	testobj.clearLoginErrorMsg();
         
    	Boolean errorsFound = false;
    	
    	// GET ALL PARAMS FROM REG FORM B
		String userid=request.getParameter("userid");  		
        String password=request.getParameter("password");
        
		// VALIDATE USER INPUT IS NOT BLANK, ZIPCODE FORMAT IS CORRECT, STATE CHOSEN, ETC
        errorsFound = validateInput(testobj, userid, password);
        
        
        
        // DISPLAY ERROR PAGE IF INPUT ERRORS, OTHERWISE DISPLAY REGISTRATION SUCCESS MSG
        if(errorsFound == true) {
        	rd=request.getRequestDispatcher("login-error.jsp"); 
        	rd.forward(request, response);
        }
        	
        // EXECUTE DB INSERT QUERY AND RENDER LOGIN PAGE
		DBConnection db = new DBConnection();
    	ResultSet res = db.getStudents();  
    	Boolean loginVerified = false;
    	String db_userid, db_pw;
    	
   	   	try {
			while(res.next()) { 
				db_userid = res.getString(1);
				db_pw = res.getString(2);
				if(db_userid.equals(userid) && db_pw.equals(password)) {
					loginVerified = true;
					testobj.setFirstname(res.getString(3));
					testobj.setLastname(res.getString(4));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	   	if(loginVerified) {
   	   		rd=request.getRequestDispatcher("login-success.jsp");
   	   	} else {
   	   		testobj.setLoginErrorMsg("Login and password are invalid. ");
   	   		rd=request.getRequestDispatcher("login-invalid.jsp"); 
   	   	}
//    	rd=request.getRequestDispatcher("regform-a.jsp"); 
    	rd.forward(request, response);
         
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


//Connection successfully executed
//USER ID	PASSWORD	FIRST NAME	LAST NAME	SS1	EMAIL			ADDRESS
//irit1234	12341234a	irit		duchan		789	irit@mail.edu	technion
//jeff1234	12345123	jv			yaakov		888	jeff@mail.com	home address
