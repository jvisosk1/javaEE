<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.mycompany.TestBean"%>
<!DOCTYPE html>
 
  <html>
    <head>
      <meta charset="UTF-8">
      <title>Success Login</title>
    </head>
  <body>
	
  	<div style="background-color: lightblue; width: 360px; padding: 2px 20px 20px 20px;">
  	
	<% 
		TestBean guru=(TestBean)request.getAttribute("gurubean"); 	
		String fname = guru.getFirstname();
		String lname = guru.getLastname();
	%>
	
	<h1>Student Registration Site</h1>
	<h3>Welcome to the SRS site,
	<%=fname%> <%=lname%><br>
		Select your next action:</h3>
		
<!-- 		<form action="http://localhost:8080/simple-web-app-1/home.jsp" method="POST">
 -->	<form action="<%=guru.url%>reg-drop-window.xhtml" method="POST">
			<input type="submit" value="Register to the Course" /><br>
		</form>
		<form action="<%=guru.url%>home.jsp" method="POST">
			<input type="submit" value="Logout" /><br>
		</form>
	</div>
  </body>
</html>