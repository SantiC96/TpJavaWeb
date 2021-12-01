<%@page import="entidades.Persona"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<%
		LinkedList<Persona> lp = (LinkedList<Persona>)request.getAttribute("listaPersonas");
	%>

<title>Listado de personas</title>
</head>
<body>
<table border=1>
		<thead>
			<tr>
				<th>DNI</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Telefono</th>
				<th>Oficio</th>
				<th>Area de Trabajo</th>
				<th>Valuación Promedio</th>
			</tr>
		</thead>
			<tbody>

			<% 
			for (Persona per : lp) { 
			 %>
			<tr>
				<td><%=per.getDni() %></td>
				<td><%=per.getNombre() %></td>
				<td><%=per.getApellido() %></td>
				<td><%=per.getTelefono() %></td>
				<td><%=per.getOficio() %></td>
				<td><%=per.getAreaTrabajo() %></td>
				<td><%=per.getValuacionPromedio() %></td>
			</tr>
			<% } %>
			</tbody>
	</table>
	<a href="index.html">Volver</a>
</body>
</html>