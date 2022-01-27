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
<title>Modificar Trabajo</title>
<link rel="stylesheet" href="../fondos.css"/>
</head>

<body>
	<h1 align="center">Modificación de un Trabajo</h1>
	<div class="container" align="left">
		<div class="row align-items-start">
 			 <div class="col" >
			<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light table-bordered" >
			<tr><td align="center" colspan="2"><lavel><font face="arial" size="5">Datos actuales</font></lavel></td></tr>
			<tr><td align="center"><font face="arial" size="5">ID Trabajo</font></td>				<td align="center"><font face="arial" size="5"><%=request.getParameter("IdTrabIn") %></font></td></tr>
			<tr><td align="center"><font face="arial" size="5">DNI Trabajador</font></td>			<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("dniTrabIn") %></label></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">DNI Cliente</font></td>				<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("dniCliIn") %></label></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Estado</font></td>					<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("estadoIn") %></label></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha de inicio</font></td>			<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("fechaIniIn") %></label></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha de fin</font></td>				<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("fechaFinIn") %></label></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Ubicación aproximada</font></td>		<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("ubiAproxIn") %></label></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha estimada de inicio</font></td>	<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("fechaEstIniIn") %></label></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha estimada de fin</font></td>	<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("fechaEstFinIn") %></label></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Valuación</font></td>				<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("valIn") %></label></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Observaciones</font></td>			<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("obsIn") %></label></font> </td></tr>
			</table>
			<div class="col">	
				<form action="/TpJava/servletTrabajos" method="post" class="login bg-light">
					<button type="submit" style="width:170px; height:35px">Cancelar</button>
				</form>
			</div>
			</div>
		<td>
		<div class="col" >
	<form action="modificarVerificacionTrab.jsp" method="post">
		<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light table-bordered">
			<tr><td align="center" colspan="2"><lavel><font face="arial" size="5">Ingrese los nuevos datos del trabajo</font></lavel></td></tr>
			<tr><td align="center"><font face="arial" size="5">ID Trabajo</font></td>				<td align="center"><font face="arial" size="5"><%=request.getParameter("IdTrabIn") %></font></td></tr>
			<tr><td align="center"><font face="arial" size="5">DNI Trabajador</font></td>			<td align="center"><input type="text" name="dniTrabIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">DNI Cliente</font></td>				<td align="center"><input type="text" name="dniCliIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Estado</font></td>					<td align="center"><input type="text" name="estadoIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha de inicio</font></td>			<td align="center"><input type="text" name="fechaIniIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha de fin</font></td>				<td align="center"><input type="text" name="fechaFinIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Ubicación aproximada</font></td>		<td align="center"><input type="text" name="ubiAproxIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha estimada de inicio</font></td>	<td align="center"><input type="text" name="fechaEstIniIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha estimada de fin</font></td>	<td align="center"><input type="text" name="fechaEstFinIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Valuación</font></td>				<td align="center"><input type="text" name="valIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Observaciones</font></td>			<td align="center"><input type="text" name="obsIn" size="30"></td></tr>
			<tr><td align="center"><button type="reset" style="width:170px; height:35px">Limpiar</button></td>	<td align="center"><button value="<%=request.getParameter("IdTrabIn") %>" name="IdTrabIn" type="submit" style="width: 170px; height: 35px">Enviar</button></td></tr>
		</table>
	</form>

	</div>
	</div>

</body>
</html>