package com.mycompany;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class register_servlet
 */
@WebServlet("/register_servlet")
public class register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	HttpSession session = request.getSession(true);

    	TestBean testobj = (TestBean)session.getAttribute("testobj");          
    	request.setAttribute("gurubean",testobj);
        RequestDispatcher rd = null;         
    	
    	// GET ALL PARAMS FROM REG FORM B
		String course_selection=request.getParameter("coursesBean.courseTitle");  		
        	
        // EXECUTE DB INSERT QUERY AND RENDER LOGIN PAGE
		DBConnection db = new DBConnection();
//    	ResultSet res = db.getIDsPWs();  
//    	ResultSet res = db.getResult();  

    	rd=request.getRequestDispatcher("reg_result.xhtml"); 
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