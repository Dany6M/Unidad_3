<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creator Form</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
				<form action="CreatorController">
					<input type="submit" name="btn_new" value="New"/><br>
					<a href="CreatorReport">Imprimir Reporte</a>
				</form>
			</th>
			<th>Id</th>
			<th>Name</th>
			<th>Last Name</th>
			<th>Filiation</th>
			<th>Area</th>
		</tr>
		<c:forEach var="creator" items="${creators}">
			<tr>
				<td>
					<form action="CreatorController"></form>
					<input type = "hidden" name = "id" value= "${creator.id}"/>
						<input type = "submit" name= "btn_edit" value= "Edit" />
						<input type = "submit" name= "btn_delete" value= "Delete"/>
				</td>
				
				<td>${creator.id}</td>
				<td>${creator.name}</td>
				<td>${creator.lastName}</td>
				<td>${creator.filiation}</td>
				<td>${creator.area}</td>
				
			</tr>
		</c:forEach>
	</table><br>
	
	<form action="CreatorReport">
		<input type="submit" name="btn_reporte" value="Reporte"/>
	</form>

</body>
</html>