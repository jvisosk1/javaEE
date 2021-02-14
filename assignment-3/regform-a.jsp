<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
  
  <div style="background-color:lightgray; width:300px">
  <h3 style="text-align: center">Registration Form A</h3>
  	
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