<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
  <style>
  	.cityfield	{ width:120px }
  	form 		{ display: table; }
	p     		{ display: table-row; }
	label 		{ display: table-cell; text-align: right; }
  </style>
  
  <head>
    <meta charset="UTF-8">
    <title>Form B</title>
  </head>
  
  <body>
  
  <div style="background-color:lightgray; width:300px">
  <h3 style="text-align: center">Registration Form B</h3>
  	
  	<form action="formB_servlet" method="POST">
	  
	  <p>
	    <label for="a">Address:</label>
	    <input class="textin" type="text" name="address" id="a" type="text"></p>
	  
	  <p>
	    <label for="f">City, State: </label>
	   	<input class="cityfield" type="text" name="city" id="f" type="text">
	    <select name="state">
		    	<option value="blank"></option>
		    	<option value="Texas">Texas</option>
		    	<option value="Colorado">Colorado</option>
		    	<option value="Oklahoma">Oklahoma</option>
		    	<option value="Florida">Florida</option>
		    	<option value="Wyoming">Wyoming</option>
		    	<option value="Oregon">Oregon</option>
		    	<option value="Montana">Montana</option>
		  	</select></p>
	    
	  <p>
	    <label for="i">Zip Code:</label>
	    <input class="textin" type="text" name="zipcode" id="i" type="text"></p>
	    
	    <input type="submit" value="Register" /><br>
	</form>
	<form action="http://localhost:8080/simple-web-app-1/regform-b.jsp" method="POST">
		<input type="submit" value="Reset" /><br>
	</form>
	
	</div>
	
  </body>
</html>