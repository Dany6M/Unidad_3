<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Boat Form</title>
</head>
<body>
	<form action="BoatController">
		<label>Name:</label><br>
		<input type="text" name="name" value="${boat.name}"/><br>
		
		<label>Origin:</label><br>
		<input type="text" name="origin" value="${boat.origin}"/><br>
		
		<label>Route:</label><br>
		<input type="text" name="route" value="${boat.route}"/><br><br>
		
		
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
		
	</form>

</body>
</html>