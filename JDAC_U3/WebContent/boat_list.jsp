<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Boat Form</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
				<form action="BoatController">
					<input type="submit" name="btn_new" value="New"/><br>
					<a href="BoatReport">Imprimir Reporte</a>
				</form>
			</th>	
				<th>Id</th>
				<th>Ship Name</th>
				<th>Origin</th>
				<th>Route</th>	
		</tr>
		<c:forEach var="boat" items="${boats}">
			<tr>
				<td>
					<form action="BoatController">
						<input type = "hidden" name = "id" value= "${boat.id}"/>
						<input type = "submit" name= "btn_edit" value= "Edit" />
						<input type = "submit" name= "btn_delete" value= "Delete"/>
					</form>
				</td>
				<td>${boat.id}</td>
				<td>${boat.name}</td>
				<td>${boat.origin}</td>
				<td>${boat.route}</td>
			
			</tr>
		</c:forEach>
	</table><br>
	
	<form action="BoatReport">
		<input type="submit" name="btn_reporte" value="Reporte"/>
	</form>
	
</body>
</html>