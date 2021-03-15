<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="java.sql.*,com.mycompany.TestBean"%>
<jsp:useBean id="con" class="com.mycompany.DBConnection"/> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <style>
  	.cityfield	{ width:120px }
  	form 		{ display: table; }
	p     		{ display: table-row; }
	label 		{ display: table-cell; text-align: right; }
  </style>
  
  <head>
    <meta charset="UTF-8">
    <title>SRS</title>
  </head>
  
  <body>
  
  <div style="background-color:lightgray; width:600px; padding:20px">
  <h1>Welcome to the Student Registration Site</h1>
  	
  	<%
	TestBean testobj = new TestBean();
	session.setAttribute("testobj", testobj);
 	%>
 
  	<h3>If you already have an account, please log in</h3>
  	<form action="login_servlet" method="POST">
	  
	  <p>
	    <label for="a">User ID:</label>
	    <input class="textin" type="text" name="userid" id="a" type="text"></p>
	    
	  <p>
	    <label for="i">Password:</label>
	    <input class="textin" type="text" name="password" id="i" type="text"></p><br>
	    
	    <input type="submit" value="Login" /><br>
	</form>
  
	<form action="<%=testobj.url%>home.jsp" method="POST">
		<input type="submit" value="Reset" /><br>
	</form>
	
	
	
	<h3>For new users, please register first</h3>
	<form action="<%=testobj.url%>regform-a.jsp" method="POST">
		<input type="submit" value="Register" /><br>
	</form>
	
	
	</div><br>
	
	<jsp:getProperty name="con" property="situation"/> <br><br>
   	   <table>
     	  <tr>
           <td>USER ID</td>
           <td>PASSWORD</td>
           <td>FIRST NAME</td>
           <td>LAST NAME</td>
           <td>SS1</td>
           <td>EMAIL</td>
           <td>ADDRESS</td>
        </tr>
     	  <% 
 			ResultSet res = con.getStudents();  	     
       	   	while(res.next()) { 
     	  %>
        <tr>
           <td><%=res.getString(1)%></td>
           <td><%=res.getString(2)%></td>
           <td><%=res.getString(3)%></td>
           <td><%=res.getString(4)%></td>
           <td><%=res.getString(5)%></td>
           <td><%=res.getString(6)%></td>
           <td><%=res.getString(7)%></td>
        </tr>
        <% } %>
       </table><br><br>
       
        <table>
     	  <tr>
           <td># Registered   </td>
           <td>Course ID   </td>
           <td>Course Name</td>
        </tr>
     	  <% 
 			res = con.getCourses();  	     
       	   	while(res.next()) { 
     	  %>
        <tr>
           <td><%=res.getString(3)%></td>
           <td><%=res.getString(1)%></td>
           <td><%=res.getString(2)%></td>
        </tr>
        <% } %>
       </table><br><br>       
       
  </body>
</html>