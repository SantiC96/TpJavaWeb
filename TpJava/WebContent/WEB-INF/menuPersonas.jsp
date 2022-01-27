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
	<form action="ABMCPersonas/Buscar/busquedaPersonas.html" method="post">
	<form action="busquedaPersonas.html">
		<br><button type="submit" style="width: 170px; height: 35px">Buscar persona por DNI</button></br>
	</form>
	<form action="servletTrabajos" method="post">
		<br><button type="submit" style="width: 170px; height: 35px">Listado general de trabajos</button></br>
	</form>
	<form action="ABMCTrabajos/Buscar/busquedaTrabajos.html" method="post">
	<form action="busquedaTrabajos.html">
		<br><button type="submit" style="width: 170px; height: 35px">Buscar trabajo por ID</button></br>
	</form>
		<form action="servletCotizaciones" method="post">
		<br><button type="submit" style="width: 170px; height: 35px">Listado general de cotizaciones</button></br>
	</form>
	<form action="ABMCCotizaciones/Buscar/busquedaCotizaciones.html" method="post">
	<form action="busquedaCotizaciones.html">
		<br><button type="submit" style="width: 170px; height: 35px">Buscar cotización por ID</button></br>
	</form>
		<form action="servletCategorias" method="post">
		<br><button type="submit" style="width: 170px; height: 35px">Listado general de categorias de trabajos</button></br>
	</form>
	<form action="ABMCCategoriaTrabajos/Buscar/busquedaCategorias.html" method="post">
	<form action="busquedaCategorias.html">
		<br><button type="submit" style="width: 170px; height: 35px">Buscar categoría por ID</button></br>
	</form>
	</h1>
	<br><p align="center"><font face="arial" size="3"><a href="index.html">Volver al inicio</a></font></p></br>
</body>
</html>