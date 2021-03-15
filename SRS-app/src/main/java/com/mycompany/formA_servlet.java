package com.mycompany;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import java.sql.*;

import javax.sql.DataSource;

import com.mycompany.DBConnection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class formA_servlet
 */
@WebServlet("/formA_servlet")
public class formA_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public formA_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Boolean validateInput(TestBean testobj, String email, String password, String password2, String userid,
    		String firstname, String lastname, String ss1, String ss2, String ss3) {
    	
    	Boolean errorsFound = false;
    	
    	if(password.length() == 0 || userid.length() == 0 || firstname.length() == 0 || lastname.length() == 0) {
    		errorsFound = true;
    		testobj.setErrorMsg("One or more of the required fields are blank. ");
    	}
    	
    	if(userid.length() < 8 || userid.length() > 16 || password.length() < 8 || password.length() > 16) {
    		errorsFound = true;
    		testobj.setErrorMsg("User ID and Passwords must be between 8-16 characters. ");
    	}
    	
    	if( !userid.matches("\\S+") || !password.matches("\\S+") ) {
			errorsFound = true;
			testobj.setErrorMsg("User ID and Passwords may not contain blank spaces. ");
		}
    	
    	if(!email.contains("@") || (!email.contains(".com") && !email.contains(".edu"))) {
			errorsFound = true;
			testobj.setErrorMsg("Invalid email address, must contain '@' and end with '.com' or '.edu'. ");
		}
    	if(!password.equals(password2)) {
			errorsFound = true;
			testobj.setErrorMsg("Passwords provided do not match. ");
		}
    	
    	String ss = ss1 + ss2 + ss3;
    	if( !ss.matches("[0-9]+") || 9 != ss.length()) {
			errorsFound = true;
			testobj.setErrorMsg("Social security number must contain only integers and be 9 digits. ");
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
    	TestBean testobj = new TestBean();
    	session.setAttribute("testobj", testobj);   	
		
    	Boolean errorsFound = false;
    	
    	// GET ALL PARAMETERS FROM REG FORM A
		String email=request.getParameter("email");  		
        String password=request.getParameter("password");
        String password2=request.getParameter("password2");
		String firstname=request.getParameter("firstname");  
        String lastname=request.getParameter("lastname");
        String userid=request.getParameter("userid");		
        String ss1=request.getParameter("ss1");  
        String ss2=request.getParameter("ss2");
        String ss3=request.getParameter("ss3");
        
        // CALL FUNCTION TO VALIDATE INPUT PARAMS AND SET ERROR MSG
        errorsFound = validateInput(testobj, email, password, password2, userid, firstname, lastname, ss1, ss2, ss3);
        
        // SET JAVABEAN OBJECT VARIABLES
        testobj.setEmail(email);
        testobj.setPassword(password);
        testobj.setPassword2(password2);
        testobj.setUserID(userid);
        testobj.setFirstname(firstname);
        testobj.setLastname(lastname);
        testobj.setSS1(ss1);
        testobj.setSS2(ss2);
        testobj.setSS3(ss3);
   	   	
        
        request.setAttribute("gurubean",testobj);
        RequestDispatcher rd = null;
        
        // DISPLAY ERROR MSG TO USER IF ERRORS FOUND, OTHERWISE PROCEED TO REG FORM B
        if(errorsFound == true)
        	rd=request.getRequestDispatcher("regerror-a.jsp"); 
        else {
        	rd=request.getRequestDispatcher("regform-b.jsp"); 	     
        }
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


