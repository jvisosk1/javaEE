<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.mycompany.TestBean"%>
<!DOCTYPE html>
 
  <html>
    <head>
      <meta charset="UTF-8">
      <title>Login Error</title>
    </head>
  <body>

  <%  
     TestBean testguru=(TestBean)request.getAttribute("gurubean");  
	 out.println("There were errors on the login form:");
  %>
  <br>
  <%  
	 out.println(testguru.getLoginErrorMsg() );  
  %>
  <br><br>
  <form action="<%=testguru.url%>home.jsp" method="POST">
  	<input type="submit" value="Go Back" /><br>
  </form>

  </body>
</html>