<%@ page contentType="text/html" language="java" import="java.sql.*"%> 
<jsp:useBean id="con" class="com.mycompany.DBConnection"/> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<html>
  <style>
  	.ssfield	{ width:40px }
  	form 		{ display: table; }
	p     		{ display: table-row; }
	label 		{ display: table-cell; text-align: right; }
  </style>
  
  <head>
    <meta charset="UTF-8">
    <title>Form A</title>
  </head>
  
  <body>
  
  <div style="background-color:lightgray; width:300px; padding: 20px">
  <h3 style="text-align: center">Registration Form A</h3>
  	<jsp:getProperty name="con" property="situation"/> 
  	<form action="formA_servlet" method="POST">
	  
	  <p>
	    <label for="a">User ID:</label>
	    <input class="textin" type="text" name="userid" id="a" type="text"></p>
	  <p>
	    <label for="b">Password:</label>
	    <input class="textin" type="text" name="password" id="b" type="text"></p>	  
	  <p>
	    <label for="c">Password (repeat):</label>
	    <input class="textin" type="text" name="password2" id="c" type="text"></p>
	  <p>
	    <label for="d">First Name:</label>
	    <input class="textin" type="text" name="firstname" id="d" type="text"></p>
	  <p>
	    <label for="e">Last Name:</label>
	    <input class="textin" type="text" name="lastname" id="e" type="text"></p>
	  <p>
	    <label for="f">Social Security #: </label>
	   	<input class="ssfield" type="text" name="ss1" id="f" type="text">-
	    <input class="ssfield" type="text" name="ss2"id="f" type="text">-
	    <input class="ssfield" type="text" name="ss3" id="f" type="text"></p>
	  <p>
	    <label for="i">Email:</label>
	    <input class="textin" type="text" name="email" id="i" type="text"></p>
	    
	    <input type="submit" value="Continue" /><br>
	</form>
	</div>

  </body>
</html>