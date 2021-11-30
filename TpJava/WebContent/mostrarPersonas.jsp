<%@page import="java.util.LinkedList"%>
<%@page import="entidades.Persona"%>
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
		<tr>
			<th>DNI</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Telefono</th>
			<th>Oficio</th>
			<th>Area de Trabajo</th>
			<th>Valuaci�n Promedio</th>
		</tr>
		<% for (Persona per : lp) { %>
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
	</table>
</body>
</html>