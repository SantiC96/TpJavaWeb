<%@page import="entidades.Trabajo"%>
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
	tra.setIdtrabajo(Integer.parseInt(request.getParameter("IdTrabIn")));
	tra.setEstado(request.getParameter("estadoIn"));
	tra.setDniTrabajador(Integer.parseInt(request.getParameter("dniTrabIn")));
	tra.setDniCliente(Integer.parseInt(request.getParameter("dniCliIn")));
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
		<input type="hidden" name="IdTrabIn" value="<%=t.getIdtrabajo()%>" />
		<input type="hidden" name="dniTrabIn" value="<%=t.getDniTrabajador()%>" />
		<input type="hidden" name="dniCliIn" value="<%=t.getDniCliente()%>" />
		<input type="hidden" name="estadoIn" value="<%=t.getEstado()%>" />
		<input type="hidden" name="fechaIniIn" value="<%=t.getFechaIni()%>" />
		<input type="hidden" name="fechaFinIn" value="<%=t.getFechaFin()%>" />
		<input type="hidden" name="ubiAproxIn" value="<%=t.getUbicacionAprox()%>" />
		<input type="hidden" name="fechaEstIniIn" value="<%=t.getFechaEstimadaIni()%>" />
		<input type="hidden" name="fechaEstFinIn" value="<%=t.getFechaEstimadaFin()%>" />
		<input type="hidden" name="valIn" value="<%=t.getObservaciones()%>" />
		<input type="hidden" name="obsIn" value="<%=t.getValuacionTrabajo()%>" />
		
		<div class="container" align="left">
			<div class="row align-items-start">
				<h1 align="center">Verifique los nuevos datos del nuevo trabajo</h1>
				<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light table-bordered">
			<tr><td align="center"><font face="arial" size="5">ID Trabajo</font></td>				<td align="center"><font face="arial" size="5"><%=request.getParameter("IdTrabIn") %></font></td></tr>
			<tr><td align="center"><font face="arial" size="5">DNI Trabajador</font></td>			<td align="center"><input type="number" name="dniTrabIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">DNI Cliente</font></td>				<td align="center"><input type="number" name="dniCliIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Estado</font></td>					<td align="center"><input type="text" name="estadoIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha de inicio</font></td>			<td align="center"><input type="text" name="fechaIniIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha de fin</font></td>				<td align="center"><input type="text" name="fechaFinIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Ubicación aproximada</font></td>		<td align="center"><input type="text" name="ubiAproxIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha estimada de inicio</font></td>	<td align="center"><input type="text" name="fechaEstIniIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Fecha estimada de fin</font></td>	<td align="center"><input type="text" name="fechaEstFinIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Valuación</font></td>				<td align="center"><input type="double" name="valIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Observaciones</font></td>			<td align="center"><input type="text" name="obsIn" size="30"></td></tr>
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