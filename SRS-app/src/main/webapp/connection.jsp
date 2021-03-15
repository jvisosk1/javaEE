<%@ page contentType="text/html" language="java" import="java.sql.*,com.mycompany.TestBean"%> 
<%--     <%@page import="demotest.TestBean"%>
 --%>
<jsp:useBean id="con" class="com.mycompany.DBConnection"/> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
   <title>Connection test</title> 
</head> 
<body> 
    <h1>Below are connection test results using DataSource thru JNDI</h1> 
     
    <jsp:getProperty name="con" property="situation"/> 
   	   
   	   <table>
   	   
     	  <tr>
           <td>USER ID</td>
           <td>PASSWORD</td>
        </tr>
     	   
     	   
     	  <% 
/*  		TestBean guru=(TestBean)request.getAttribute("gurubean"); 	
     	 	con.setSearch(guru.getUserID(), guru.getPassword(), guru.getFirstname(), guru.getLastname(), 
     		guru.getSS1(), guru.getEmail(), guru.getAddress());  */
 			ResultSet res = con.getStudents();  	     
       	   	while(res.next()) { 
     	  %>

        <tr>
           <td><%=res.getString(1)%></td>
           <td><%=res.getString(2)%></td>
        </tr>
        <% 
           } 
        %>
   	   
       </table>
   	   
</body>
</html>      