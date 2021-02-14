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
	 out.println("There were errors on the registration form:");
  %>
  <br>
  <%  
	 out.println(testguru.getErrorMsgB() );  
  %>
  <br><br>
  <form action="http://localhost:8080/simple-web-app-1/regform-b.jsp" method="POST">
  	<input type="submit" value="Go Back" /><br>
  </form>

  </body>
</html>