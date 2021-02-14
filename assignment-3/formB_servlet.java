package demotest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class mvc_servlet
 */
@WebServlet("/formB_servlet")
public class formB_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public formB_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Boolean validateInput(TestBean testobj, String city, String address, String zipcode, String state) {
    	
    	Boolean errorsFound = false;
    	
    	if(city.length() == 0 || address.length() == 0 || zipcode.length() == 0) {
    		errorsFound = true;
    		testobj.setErrorMsgB("One or more of the required fields are blank. ");
    	}
    	
    	if(state.equals("blank")) {
    		errorsFound = true;
    		testobj.setErrorMsgB("Please select a state. ");
    	}
    	
    	if( !zipcode.matches("[0-9]+") || 5 != zipcode.length()) {
			errorsFound = true;
			testobj.setErrorMsgB("Zip code must contain only integers and be 5 digits. ");
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
        	testobj.clearErrorMsgB();
        }
         
    	Boolean errorsFound = false;
    	
    	// GET ALL PARAMS FROM REG FORM B
		String address=request.getParameter("address");  		
        String city=request.getParameter("city");
        String zipcode=request.getParameter("zipcode");
		String state=request.getParameter("state");  
        
		// VALIDATE USER INPUT IS NOT BLANK, ZIPCODE FORMAT IS CORRECT, STATE CHOSEN, ETC
        errorsFound = validateInput(testobj, city, address, zipcode, state);
        
        // SET ATTRIBUTES IN TESTBEAN OBJECT
        testobj.setAddress(address);
        testobj.setCity(city);
        testobj.setState(state);
        testobj.setZipcode(zipcode);
        
        
        request.setAttribute("gurubean",testobj);
        RequestDispatcher rd = null;
        
        // DISPLAY ERROR PAGE IF INPUT ERRORS, OTHERWISE DISPLAY REGISTRATION SUCCESS MSG
        if(errorsFound == true)
        	rd=request.getRequestDispatcher("regerror-b.jsp"); 
        else rd=request.getRequestDispatcher("reg-success.jsp"); 
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
