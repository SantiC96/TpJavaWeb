<%@page import="entidades.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
		<h1 align="center">Verifique los nuevos datos de la persona</h1>
		<input type="hidden" name="dni" value="<%=p.getDni()%>" />
		<input type="hidden" name="nombre" value="<%=p.getNombre()%>" />
		<input type="hidden" name="apellido" value="<%=p.getApellido()%>" />
		<input type="hidden" name="telefono" value="<%=p.getTelefono()%>" />
		<input type="hidden" name="oficio" value="<%=p.getOficio()%>" />
		<input type="hidden" name="area" value="<%=p.getAreaTrabajo()%>" />
		<input type="hidden" name="valuacion" value="<%=p.getValuacionPromedio()%>" />
		
		<table border="1" align="center" bgcolor="silver">
			<tr><td align="center"><font face="arial" size="5">DNI</font></td>					<td align="center"><font face="arial" size="5"><%=request.getParameter("DNIin") %></font></td></tr>
			<tr><td align="center"><font face="arial" size="5">Nombre</font></td>				<td align="center"><label size="30"><%=request.getParameter("nomIn") %></label> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Apellido</font></td>				<td align="center"><label size="30"><%=request.getParameter("apeIn") %></label> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Teléfono</font></td>				<td align="center"><label size="30"><%=request.getParameter("telIn") %></label> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Oficio</font></td>				<td align="center"><label size="30"><%=request.getParameter("ofiIn") %></label> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Area de Trabajo</font></td>		<td align="center"><label size="30"><%=request.getParameter("areaIn") %></label> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Valuación promedio</font></td>	<td align="center"><label size="30"><%=request.getParameter("valIn") %></label> </td></tr>
			<tr><td align="center"><a href="menuPersonas.html"><button type="button" style="width:170px; height:35px">Cancelar</button></a></td>	
				<td align="center"><button type="submit" style="width: 170px; height: 35px">Aceptar</button></td></tr>
		</table>
	</form>



</body>
</html>