<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="demotest.TestBean"%>
<!DOCTYPE html>
 
  <html>
    <head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
    </head>
  <body>

  <%  
     TestBean testguru=(TestBean)request.getAttribute("gurubean");  
	 out.println("Thank you for registering, " + testguru.getFirstname() + " " + testguru.getLastname());
  %>
  <br>
  <%  
	 out.println("Your confirmation email will be sent to: " + testguru.getEmail() );  
  %>

  </body>
</html>