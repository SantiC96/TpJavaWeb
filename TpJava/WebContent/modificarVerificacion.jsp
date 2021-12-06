<%@page import="entidades.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<link rel="stylesheet" href="fondos.css"/>

<% Persona p= new Persona();
	p.setDni(Integer.parseInt(request.getParameter("DNIin")));
	p.setNombre(request.getParameter("nomIn"));
	p.setApellido(request.getParameter("apeIn"));
	p.setTelefono(request.getParameter("telIn"));
	p.setOficio(request.getParameter("ofiIn"));
	p.setAreaTrabajo(request.getParameter("areaIn"));
	p.setValuacionPromedio(Double.parseDouble(request.getParameter("valIn")));
	String aux=p.toString();
%>

<meta charset="ISO-8859-1">
<title>Verificar datos</title>
</head>
<body>

<form action="servletModificarPersonas" method="post">
		<input type="hidden" name="dni" value="<%=p.getDni()%>" />
		<input type="hidden" name="nombre" value="<%=p.getNombre()%>" />
		<input type="hidden" name="apellido" value="<%=p.getApellido()%>" />
		<input type="hidden" name="telefono" value="<%=p.getTelefono()%>" />
		<input type="hidden" name="oficio" value="<%=p.getOficio()%>" />
		<input type="hidden" name="area" value="<%=p.getAreaTrabajo()%>" />
		<input type="hidden" name="valuacion" value="<%=p.getValuacionPromedio()%>" />
		<div class="container" align="left">
			<h1 align="center">Verifique los nuevos datos de la persona</h1>
			<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light table-bordered">
				<tr><td align="center"><font face="arial" size="5">DNI</font></td>					<td align="center"><font face="arial" size="5"><%=request.getParameter("DNIin") %></font></td></tr>
				<tr><td align="center"><font face="arial" size="5">Nombre</font></td>				<td align="center"><font face="arial" size="5"><%=request.getParameter("nomIn") %></font></td></tr>
				<tr><td align="center"><font face="arial" size="5">Apellido</font></td>				<td align="center"><font face="arial" size="5"><%=request.getParameter("apeIn") %></font> </td></tr>
				<tr><td align="center"><font face="arial" size="5">Teléfono</font></td>				<td align="center"><font face="arial" size="5"><%=request.getParameter("telIn") %></font> </td></tr>
				<tr><td align="center"><font face="arial" size="5">Oficio</font></td>				<td align="center"><font face="arial" size="5"><%=request.getParameter("ofiIn") %></font> </td></tr>
				<tr><td align="center"><font face="arial" size="5">Area de Trabajo</font></td>		<td align="center"><font face="arial" size="5"><%=request.getParameter("areaIn") %></font> </td></tr>
				<tr><td align="center"><font face="arial" size="5">Valuación promedio</font></td>	<td align="center"><font face="arial" size="5"><%=request.getParameter("valIn") %></font> </td></tr>
				<tr><td align="center"><a href="menuPersonas.html"><button type="button" style="width:170px; height:35px">Cancelar</button></a></td>	
					<td align="center"><button type="submit" style="width: 170px; height: 35px">Aceptar</button></td></tr>
			</table>
		</div>
	</form>
	
</body>
</html>