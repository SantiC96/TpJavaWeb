<%@page import="entidades.Trabajo"%>
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
<link rel="stylesheet" href="../fondos.css"/>

<% 	Trabajo tra= new Trabajo();
	Persona cli = new Persona();
	Persona trab = new Persona();
	
	tra.setIdtrabajo(Integer.parseInt(request.getParameter("IdTrabIn")));
	tra.setEstado(request.getParameter("estadoIn"));
	
	trab.setDni(Integer.parseInt(request.getParameter("dniTrabIn")));
	tra.setTrabajador(trab);
	
	cli.setDni(Integer.parseInt(request.getParameter("dniCliIn")));
	tra.setCliente(cli);

	tra.setUbicacionAprox(request.getParameter("ubiAproxIn"));
	tra.setFechaEstimadaIni(request.getParameter("fechaEstIniIn"));
	tra.setFechaEstimadaFin(request.getParameter("fechaEstFinIn"));
	tra.setFechaIni(request.getParameter("fechaIniIn"));
	tra.setFechaFin(request.getParameter("fechaFinIn"));
	tra.setValuacionTrabajo(Double.parseDouble(request.getParameter("valIn")));
	tra.setObservaciones(request.getParameter("obsIn"));
	String aux=tra.toString();
%>

<meta charset="ISO-8859-1">
<title>Verificar datos</title>
</head>
<body>
<form action="/TpJava/servletModificarTrabajos" method="post">
		<input type="hidden" name="IdTrabIn" value="<%=tra.getIdtrabajo()%>" />
		<input type="hidden" name="dniTrabIn" value="<%=tra.getDniTrabajador()%>" />
		<input type="hidden" name="dniCliIn" value="<%=tra.getDniCliente()%>" />
		<input type="hidden" name="estadoIn" value="<%=tra.getEstado()%>" />
		<input type="hidden" name="fechaIniIn" value="<%=tra.getFechaIni()%>" />
		<input type="hidden" name="fechaFinIn" value="<%=tra.getFechaFin()%>" />
		<input type="hidden" name="ubiAproxIn" value="<%=tra.getUbicacionAprox()%>" />
		<input type="hidden" name="fechaEstIniIn" value="<%=tra.getFechaEstimadaIni()%>" />
		<input type="hidden" name="fechaEstFinIn" value="<%=tra.getFechaEstimadaFin()%>" />
		<input type="hidden" name="valIn" value="<%=tra.getValuacionTrabajo()%>" />
		<input type="hidden" name="obsIn" value="<%=tra.getObservaciones()%>" />
		
		<div class="container" align="left">
			<div class="row align-items-start">
				<h1 align="center">Verifique los nuevos datos del trabajo</h1>
				<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light table-bordered">
			<tr><td align="center"><font face="arial" size="5">ID Trabajo</font></td>				<td align="center"><font face="arial" size="5"><%=request.getParameter("IdTrabIn") %></font></td></tr>
			<tr><td align="center"><font face="arial" size="5">DNI Trabajador</font></td>			<td align="center"><font face="arial" size="5"><%=request.getParameter("dniTrabIn") %></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">DNI Cliente</font></td>				<td align="center"><font face="arial" size="5"><%=request.getParameter("dniCliIn") %></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Estado</font></td>					<td align="center"><font face="arial" size="5"><%=request.getParameter("estadoIn") %></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha de inicio</font></td>			<td align="center"><font face="arial" size="5"><%=request.getParameter("fechaIniIn") %></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha de fin</font></td>				<td align="center"><font face="arial" size="5"><%=request.getParameter("fechaFinIn") %></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Ubicación aproximada</font></td>		<td align="center"><font face="arial" size="5"><%=request.getParameter("ubiAproxIn") %></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha estimada de inicio</font></td>	<td align="center"><font face="arial" size="5"><%=request.getParameter("fechaEstIniIn") %></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha estimada de fin</font></td>	<td align="center"><font face="arial" size="5"><%=request.getParameter("fechaEstFinIn") %></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Valuación</font></td>				<td align="center"><font face="arial" size="5"><%=request.getParameter("valIn") %></font> </td></tr>
			<tr><td align="center"><font face="arial" size="5">Observaciones</font></td>			<td align="center"><font face="arial" size="5"><%=request.getParameter("obsIn") %></font> </td></tr>
				</table>
	
			<div class="row">
					<div class="col">
						<button value="<%=request.getParameter("IdTrabIn") %>" name="IdTrabIn" type="submit" style="width:170px; height:35px">Aceptar</button>
					</div>
			</form>
					<div class="col">	
						<form action="/TpJava/servletTrabajos" method="post" class="login bg-light">
							<button type="submit" style="width:170px; height:35px">Cancelar</button>
						</form>
						</div>
		</div>
	</div>
</body>
</html>