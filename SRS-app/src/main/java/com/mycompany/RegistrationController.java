package com.mycompany;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.ejb.EJB;	
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.mycompany.StatusBean;
import com.mycompany.TestBean;

@WebServlet("/ejbclient")

public class RegistrationController extends HttpServlet {

        @EJB StatusBean status_bean;

     public RegistrationController () {
        super();
     }
 
    // Method to handle POST method request.
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      doPost(request, response);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	HttpSession session = req.getSession(true);
    	TestBean testobj = new TestBean();
    	session.setAttribute("testobj", testobj);  
    	testobj.status_report = "";
    	// System.out.println(testobj.status_report);

		// Set response content type
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String[] checked_courses = {	
			req.getParameter("cloud"), req.getParameter("db"), req.getParameter("agile"), 
			req.getParameter("largeDB"), req.getParameter("javaEE"), req.getParameter("hadoop")
		};

		Boolean all_null = true;
		String course_seating = "";

		for(int i=0; i < checked_courses.length; i++){
			if(checked_courses[i] != null){
				course_seating += status_bean.getStatus(checked_courses[i]);
				all_null = false;
			}
		}

		if(all_null){
			course_seating = status_bean.getAllStatus();
		}

		testobj.status_report = 
		   "<html>\n" +
		      "<body>\n" +
		         "<br>" + course_seating +
		         "</br>Click <a href='home.jsp'>here</a> to go to main page</br>" +
		      "</body>" +
		   "</html>";

		req.setAttribute("gurubean",testobj);
		RequestDispatcher rd = req.getRequestDispatcher("reg-status.jsp"); 
    	rd.forward(req, resp);

		// out.println(
		//    "<html>\n" +
		//       "<body>\n" +
		//          "<br>" + course_seating +
		//          "</br>Click <a href='home.jsp'>here</a> to go to main page</br>" +
		//       "</body>" +
		//    "</html>"
		// );

        
    } 
}








