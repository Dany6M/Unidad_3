<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creator Form</title>
</head>
<body>
	<form action="CreatorController">
		<label>Name:</label><br/>
		<input type="text" name="name" value="${creator.name}"/><br>
		
		<label>Last Name:</label><br/>
		<input type="text" name="lastName" value="${creator.lastName}"/><br>
		
		<label>Filiation:</label><br/>
		<input type="text" name="filiation" value="${creator.filiation}"/><br>
		
		
		<label>Area:</label><br/>
		<input type="text" name="area" value="${creator.area}"/><br/><br/>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	
	</form>
</body>
</html>