<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.mycompany.TestBean"%>
<!DOCTYPE html>
 
  <html>
    <head>
      <meta charset="UTF-8">
      <title>Invalid Login</title>
    </head>
  <body>
	
  	<div style="background-color: lightblue; width: 360px; padding: 2px 20px 20px 20px;">
  	<h1>Student Registration Site</h1>
	<h3>Wrong UserID and/or Password<br>
		Please try to login again or register</h3>
		
		<% TestBean guru = (TestBean)request.getAttribute("gurubean"); %>
		<form action="<%=guru.url%>home.jsp" method="POST">
			<input type="submit" value="Login" /><br>
		</form>
		<form action="<%=guru.url%>regform-a.jsp" method="POST">
			<input type="submit" value="Register to SRS" /><br>
		</form>
	</div>
  </body>
</html>