<%@page import="entidades.Persona"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">

	<%
		LinkedList<Persona> lp = (LinkedList<Persona>)request.getAttribute("listaPersonas");
	%>

<title>Listado de personas</title>
</head>
<body>
<p class="fs-2 font-monospace" align="center" >Listado de personas</p>
	<fieldset>
	<div class="container" align="left">
 			 <div class="row g-4" >
 			 <div class="col col-md-10">
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
		</div>
		<div class="col">
		  <a href="menuPersonas.html"><button type="button" class="btn btn-light btn-lg"  style="width:100px; height:35px;r">Volver</button></a>
		 </div>
		 </div>
		 </div>
	</fieldset>
	
</body>
</html>