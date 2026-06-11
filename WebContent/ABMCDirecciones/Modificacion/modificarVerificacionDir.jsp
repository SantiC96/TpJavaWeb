<%@page import="entidades.Direccion"%>
<%@page import="entidades.Localidad"%>
<%@page import="conexionSQL.DataLocalidad"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../fondos.css"/>

<% 	Direccion dir= new Direccion();
	Localidad loc = new Localidad();
	DataLocalidad dLoc = new DataLocalidad();
	
	dir.setIdDireccion(Integer.parseInt(request.getParameter("IdDirIn")));
	dir.setCalle(request.getParameter("Calle"));
	dir.setAltura(request.getParameter("Altura"));
	
	loc.setDescripcion(request.getParameter("DescLoc"));
	dir.setLocalidad(dLoc.getLocByDesc(loc));
	
	
	//Falta la direccion

%>

<meta charset="ISO-8859-1">
<title>Verificar datos</title>
</head>
<body>
<form action="/TpJava/servletModificarDirecciones" method="post">
		<input type="hidden" name="IdDir" value="<%=dir.getIdDireccion()%>" />
		<input type="hidden" name="Calle" value="<%=dir.getCalle()%>" />
		<input type="hidden" name="Altura" value="<%=dir.getAltura()%>" />
		<input type="hidden" name="DescLoc" value="<%=dir.getLocalidad().getDescripcion()%>" />

		<div class="container" align="left">
			<div class="row align-items-start">
				<h1 align="center">Verifique los nuevos datos de la direccion</h1>
				<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light table-bordered">
					<tr><td align="center"><font face="arial" size="5">ID Direccion</font></td>			<td align="center"><font face="arial" size="5"><font face="arial" size="5"><%=request.getParameter("IdDirIn") %></font></td></tr>
					<tr><td align="center"><font face="arial" size="5">Calle</font></td>				<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("Calle") %></label></font> </td></tr>
					<tr><td align="center"><font face="arial" size="5">Altura</font></td>				<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("Altura") %></label> </font></td></tr>
					<tr><td align="center"><font face="arial" size="5">Localidad</font></td>			<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("DescLoc") %></label></font> </td></tr>
				</table>
	
			<div class="row">
					<div class="col">
						<button value="<%=request.getParameter("IdDirIn") %>" name="IdDirIn" type="submit" class="btn btn-light border border-dark" style="width:170px; height:35px">Aceptar</button>
					</div>
			</form>
					<div class="col">	
						<form action="/TpJava/servletDirecciones" method="post">
							<button type="submit" class="btn btn-light border border-dark" style="width:170px; height:35px">Cancelar</button>
						</form>
						</div>
		</div>
	</div>
</body>
</html>