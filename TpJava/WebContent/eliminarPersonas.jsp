<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Eliminar</title>
<link rel="stylesheet" href="fondos.css"/>
<h1 align="center">�Desea eliminar la siguiente persona?</h1>
</head>
<body>
<form action="servletEliminarPersonas" method="post" >
		<div class="container" align="left">
		<div class="row align-items-start">
		<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light table-bordered" >
				<tr><td align="center" colspan="2"><lavel><font face="arial" size="5">Datos actuales</font></lavel></td></tr>
				<tr><td align="center"><font face="arial" size="5">DNI</font></td>					<td align="center"><font face="arial" size="5"><font face="arial" size="5"><%=request.getParameter("DNIin") %></font></td></tr>
				<tr><td align="center"><font face="arial" size="5">Nombre</font></td>				<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("nombre") %></label></font> </td></tr>
				<tr><td align="center"><font face="arial" size="5">Apellido</font></td>				<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("apellido") %></label> </font></td></tr>
				<tr><td align="center"><font face="arial" size="5">Tel�fono</font></td>				<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("telefono") %></label></font> </td></tr>
				<tr><td align="center"><font face="arial" size="5">Oficio</font></td>				<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("oficio") %></label></font> </td></tr>
				<tr><td align="center"><font face="arial" size="5">Area de Trabajo</font></td>		<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("area") %></label> </font></td></tr>
				<tr><td align="center"><font face="arial" size="5">Valuaci�n promedio</font></td>	<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("valuacion") %></label></font> </td></tr>
				<tr><td align="center"><a href="menuPersonas.html"><button type="button" style="width:170px; height:35px">Cancelar</button></a></td>   <td align="center"><button value="<%=request.getParameter("DNIin") %>" name="DNIin" type="submit" style="width:170px; height:35px">Aceptar</button></td></tr>
			</table>
	</form>
	</div>
	</div>
</body>
</html>