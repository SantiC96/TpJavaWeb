<%@page import="entidades.Localidad"%>
<%@page import="entidades.Provincia"%>
<%@page import="conexionSQL.DataProvincia"%>
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

<% 	Localidad loc= new Localidad();
	Provincia prov = new Provincia();
	DataProvincia dProv = new DataProvincia();
	
	loc.setIdLocalidad(Integer.parseInt(request.getParameter("IdLocIn")));
	loc.setCodPostal(request.getParameter("CodPostal"));
	loc.setDescripcion(request.getParameter("Descripcion"));
	
	prov.setDescripcion(request.getParameter("DescProv"));
	loc.setProvincia(dProv.getProvByDesc(prov));
	loc.setProvincia(prov);
	

%>

<meta charset="ISO-8859-1">
<title>Verificar datos</title>
</head>
<body>
<form action="/TpJava/servletModificarLocalidades" method="post">
		<input type="hidden" name="IdDir" value="<%=loc.getIdLocalidad()%>" />
		<input type="hidden" name="CodPostal" value="<%=loc.getCodPostal()%>" />
		<input type="hidden" name="Descripcion" value="<%=loc.getDescripcion()%>" />
		<input type="hidden" name="DescProv" value="<%=loc.getProvincia().getDescripcion()%>" />

		<div class="container" align="left">
			<div class="row align-items-start">
				<h1 align="center">Verifique los nuevos datos de la localidad</h1>
				<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light table-bordered">
					<tr><td align="center"><font face="arial" size="5">ID Localidad</font></td>			<td align="center"><font face="arial" size="5"><font face="arial" size="5"><%=request.getParameter("IdLocIn") %></font></td></tr>
					<tr><td align="center"><font face="arial" size="5">Código Postal</font></td>			<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("CodPostal") %></label></font> </td></tr>
					<tr><td align="center"><font face="arial" size="5">Nombre</font></td>			<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("Descripcion") %></label> </font></td></tr>
					<tr><td align="center"><font face="arial" size="5">Provincia</font></td>			<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("DescProv") %></label></font> </td></tr>
				</table>
	
			<div class="row">
					<div class="col">
						<button value="<%=request.getParameter("IdLocIn") %>" name="IdLocIn" type="submit" class="btn btn-light border border-dark" style="width:170px; height:35px">Aceptar</button>
					</div>
			</form>
					<div class="col">	
						<form action="/TpJava/servletLocalidades" method="post">
							<button type="submit" class="btn btn-light border border-dark" style="width:170px; height:35px">Cancelar</button>
						</form>
						</div>
		</div>
	</div>
</body>
</html>