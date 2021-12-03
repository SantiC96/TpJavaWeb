<%@page import="entidades.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%Persona per = (Persona)request.getAttribute("persona"); %>
<title>Datos de la persona</title>
</head>
<body>
<p class="fs-2 font-monospace" align="center" >Datos de <%=per.getNombre() %> <%=per.getApellido() %></p>
	<fieldset>
		<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3">	
		  <thead  class="table-dark">
		    <tr>
		      <th scope="col">DNI</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Apellido</th>
		      <th scope="col">Telefono</th>
		      <th scope="col">Oficio</th>
		      <th scope="col">Area de Trabajo</th>
		      <th scope="col">Valuación Promedio</th>
		      <td scope="col" align="center""><a href="menuPersonas.html"><button type="button" class="btn btn-light"  style="width:100px; height:35px;r">Volver</button></a></td>
		    </tr>
		  </thead>
		  <tbody>
			<tr>
				<td><%=per.getDni() %></td>
				<td><%=per.getNombre() %></td>
				<td><%=per.getApellido() %></td>
				<td><%=per.getTelefono() %></td>
				<td><%=per.getOficio() %></td>
				<td><%=per.getAreaTrabajo() %></td>
				<td><%=per.getValuacionPromedio() %></td>
			</tr>
			</tbody>
		</table>
	</fieldset>
</body>
</html>