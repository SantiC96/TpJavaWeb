<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu de personas</title>
</head>
<body>
	<h1 align="center">Menu general
	<form action="servletPersonas" method="post">
		<br><button type="submit" style="width: 170px; height: 35px">Listado general de personas</button></br>
	</form>
	<form action="busquedaPersonas.html" method="post">
		<br><button type="submit" style="width: 170px; height: 35px">Buscar persona por DNI</button></br>
	</form></h1>
	<br><p align="center"><font face="arial" size="3"><a href="index.html">Volver al inicio</a></font></p></br>
</body>
</html>