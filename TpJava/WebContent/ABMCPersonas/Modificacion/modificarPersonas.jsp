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
<title>Modificar Persona</title>
<link rel="stylesheet" href="../fondos.css"/>
</head>

<body>
	<h1 align="center">Modificacion de una Persona</h1>
	<div class="container" align="left">
		<div class="row align-items-start">
 			 <div class="col" >
			<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light table-bordered" >
				<tr><td align="center" colspan="2"><lavel><font face="arial" size="5">Datos actuales</font></lavel></td></tr>
				<tr><td align="center"><font face="arial" size="5">DNI</font></td>					<td align="center"><font face="arial" size="5"><font face="arial" size="5"><%=request.getParameter("DNIin") %></font></td></tr>
				<tr><td align="center"><font face="arial" size="5">Nombre</font></td>				<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("nombre") %></label></font> </td></tr>
				<tr><td align="center"><font face="arial" size="5">Apellido</font></td>				<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("apellido") %></label> </font></td></tr>
				<tr><td align="center"><font face="arial" size="5">Teléfono</font></td>				<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("telefono") %></label></font> </td></tr>
				<tr><td align="center"><font face="arial" size="5">Oficio</font></td>				<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("oficio") %></label></font> </td></tr>
				<tr><td align="center"><font face="arial" size="5">Area de Trabajo</font></td>		<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("area") %></label> </font></td></tr>
				<tr><td align="center"><font face="arial" size="5">Valuación promedio</font></td>	<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("valuacion") %></label></font> </td></tr>
			</table>
			<div class="col">	
				<form action="/TpJava/servletPersonas" method="post" class="login bg-light">
					<button type="submit" style="width:170px; height:35px">Cancelar</button>
				</form>
			</div>
			</div>
		<td>
		<div class="col" >
	<form action="modificarVerificacionPers.jsp" method="post">
		<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light table-bordered">
			<tr><td align="center" colspan="2"><lavel><font face="arial" size="5">Ingrese los nuevos datos de la persona</font></lavel></td></tr>
			<tr><td align="center"><font face="arial" size="5">DNI</font></td>	<td align="center"><font face="arial" size="5"><%=request.getParameter("DNIin") %></font></td></tr>
			<tr><td align="center"><font face="arial" size="5">Nombre</font></td>	<td align="center"><input type="text" name="nomIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Apellido</font></td>	<td align="center"><input type="text" name="apeIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Teléfono</font></td>	<td align="center"><input type="text" name="telIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Oficio</font></td>	<td align="center"><input type="text" name="ofiIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Area de Trabajo</font></td>	<td align="center"><input type="text" name="areaIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Valuación promedio</font></td>	<td align="center"><input type="text" name="valIn" size="30"></td></tr>
			<tr><td align="center"><button type="reset" style="width:170px; height:35px">Limpiar</button></td>	<td align="center"><button value="<%=request.getParameter("DNIin") %>" name="DNIin" type="submit" style="width: 170px; height: 35px">Enviar</button></td></tr>
		</table>
	</form>

	</div>
	</div>

</body>
</html>