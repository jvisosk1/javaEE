<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.mycompany.TestBean"%>
<!DOCTYPE html>
 
  <html>
    <head>
      <meta charset="UTF-8">
      <title>Status Report</title>
    </head>

    <%  
      TestBean testguru=(TestBean)request.getAttribute("gurubean");  
      out.println(testguru.status_report);
    %>

  <body>
  <br>
  <br>
  <br>

  </body>
</html>