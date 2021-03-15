<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.mycompany.TestBean"%>
<!DOCTYPE html>
 
  <html>
    <head>
      <meta charset="UTF-8">
      <title>Registration Complete!</title>
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
  <br><br>
  <form action="<%=testguru.url%>home.jsp" method="POST">
  	<input type="submit" value="Login" /><br>
  </form>

  </body>
</html>