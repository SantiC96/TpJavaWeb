<%@page import="entidades.Trabajo"%>
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
<link rel="stylesheet" href="fondos.css"/>
<meta charset="ISO-8859-1">

	<%
		LinkedList<Trabajo> lt = (LinkedList<Trabajo>)request.getAttribute("listaTrabajos");
	%>

<title>Listado de Trabajos</title>
</head>
<body>
<p class="fs-2 font-monospace" align="center" >Listado de trabajos</p>
	<fieldset>
		<div class="container" align="left" >
 			 <div class="row g-4" >
 			 	<div class="col col-md-10">
					<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light">	
					  <thead  class="table-dark">
					    <tr>
					      <th scope="col">ID Trabajo</th>
					      <th scope="col">DNI Trabajador</th>
					      <th scope="col">DNI Cliente</th>
					      <th scope="col">Estado</th>
					      <th scope="col">Fecha de inicio</th>
					      <th scope="col">Fecha de fin</th>
					      <th scope="col">Ubicación aproximada</th>
					      <th scope="col">Fecha estimada de inicio</th>
					      <th scope="col">Fecha estimada de fin</th>
					      <th scope="col">Valuación</th>
					      <th scope="col">Precio final</th>
					      <th scope="col">Observaciones</th>
					      <th scope="col">Id localidad</th>
					      <th colspan="2" ><a href="ABMCTrabajos/Agregar/agregarTrabajos.html"><button type="button" class=" bot btn btn-light btn-lg"  style="width:210px; height:35px">Agregar</button></a></th>
					    </tr>
					  </thead>  
					  <tbody>
						<% 
						for (Trabajo tra : lt) { 
						%>
						<tr>
							<td><%=tra.getIdTrabajo() %></td>
							<td><%=tra.getDniTrabajador() %></td>
							<td><%=tra.getDniCliente() %></td>
							<td><%=tra.getEstado() %></td>
							<td><%=tra.getFechaIni() %></td>
							<td><%=tra.getFechaFin() %></td>
							<td><%=tra.getUbicacionAprox() %></td>
							<td><%=tra.getFechaEstimadaIni() %></td>
							<td><%=tra.getFechaEstimadaFin() %></td>
							<td><%=tra.getValuacionTrabajo() %></td>
							<td><%=tra.getPrecioFinal() %></td>
							<td><%=tra.getObservaciones() %></td>
							<td><%=tra.getIdLocalidad() %></td>
							
							<form action="ABMCTrabajos/Modificacion/modificarTrabajos.jsp" method="get" >
								<input type="hidden" name="dniTrabIn" value="<%=tra.getDniTrabajador()%>" />
								<input type="hidden" name="dniCliIn" value="<%=tra.getDniCliente()%>" />
								<input type="hidden" name="estadoIn" value="<%=tra.getEstado()%>" />
								<input type="hidden" name="fechaIniIn" value="<%=tra.getFechaIni()%>" />
								<input type="hidden" name="fechaFinIn" value="<%=tra.getFechaFin()%>" />
								<input type="hidden" name="ubiAproxIn" value="<%=tra.getUbicacionAprox()%>" />
								<input type="hidden" name="fechaEstIniIn" value="<%=tra.getFechaEstimadaIni()%>" />
								<input type="hidden" name="fechaEstFinIn" value="<%=tra.getFechaEstimadaFin()%>" />
								<input type="hidden" name="valIn" value="<%=tra.getValuacionTrabajo()%>" />
								<input type="hidden" name="precioFin" value="<%=tra.getPrecioFinal()%>" />
								<input type="hidden" name="obsIn" value="<%=tra.getObservaciones()%>" />
								<input type="hidden" name="idLocIn" value="<%=tra.getIdLocalidad()%>" />
							<td><button  value="<%=tra.getIdTrabajo() %>" name="IdTrabIn" type="submit" class="btn btn-light btn-lg"  style="width:100px; height:35px">Editar</button></td>
						</form>
						
						<form action="ABMCTrabajos/Eliminar/eliminarTrabajos.jsp" method="get" >
								<input type="hidden" name="DNITrabajador" value="<%=tra.getDniTrabajador()%>" />
								<input type="hidden" name="DNICliente" value="<%=tra.getDniCliente()%>" />
								<input type="hidden" name="Estado" value="<%=tra.getEstado()%>" />
								<input type="hidden" name="FechaIni" value="<%=tra.getFechaIni()%>" />
								<input type="hidden" name="FechaFin" value="<%=tra.getFechaFin()%>" />
								<input type="hidden" name="UbiAprox" value="<%=tra.getUbicacionAprox()%>" />
								<input type="hidden" name="FechaIniEst" value="<%=tra.getFechaEstimadaIni()%>" />
								<input type="hidden" name="FechaFinEst" value="<%=tra.getFechaEstimadaFin()%>" />
								<input type="hidden" name="Valuacion" value="<%=tra.getValuacionTrabajo()%>" />
								<input type="hidden" name="PrecioFin" value="<%=tra.getPrecioFinal()%>" />
								<input type="hidden" name="Observaciones" value="<%=tra.getObservaciones()%>" />
								<input type="hidden" name="IdLocalidad" value="<%=tra.getIdLocalidad()%>" />
							<td><button  value="<%=tra.getIdTrabajo() %>" name="IdTrabIn" type="submit" class="btn btn-light btn-lg"  style="width:100px; height:35px">Borrar</button></td>
						</form>
						</tr>
								<% } %>
						</tbody>
					</table>
				</div>
			<div class="col">
				<form action="servletRedireccionMenuPersonas" method="post" class="login bg-light">
			  		<button type="submit" >Volver</button>
			  	</form>
			</div>
		 	</div>
		</div>
	</fieldset>
</body>
</html>