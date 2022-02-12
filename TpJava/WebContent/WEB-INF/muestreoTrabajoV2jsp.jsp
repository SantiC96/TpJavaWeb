<%@page import="entidades.Trabajo"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado trabajos</title>
	<link rel="stylesheet" href="tablas.css">
	<meta charset="ISO-8859-1">

	<%
		LinkedList<Trabajo> lt = (LinkedList<Trabajo>)request.getAttribute("listaTrabajos");
	%>

<title>Listado de Trabajos</title>
</head>
<body>
<h1 class="main__title" align="center" >Listado de personas</h1>
    <main class="main">
        <section class="main__section">
            <table class="section__table" border="1px">
            	<thead>
	                <tr class="table__tr">
		                <th class="table__title">Id Trabajo</th>
						<th class="table__title">DNI Trabajador</th>
						<th class="table__title">DNI Cliente</th>
						<th class="table__title">Estado</th>
						<th class="table__title">Fecha de inicio</th>
						<th class="table__title">Fecha de fin</th>
						<th class="table__title">Ubicación aproximada</th>
						<th class="table__title">Fecha estimada de inicio</th>
						<th class="table__title">Fecha estimada de fin</th>
						<th class="table__title">Valuación</th>
						<th class="table__title">Precio final</th>
						<th class="table__title">Observaciones</th>
						<th class="table__title">Id localidad</th>
						<th colspan="2" ><a href="ABMCTrabajos/Agregar/agregarTrabajos.html"><button type="button" class="button--tabla" style="width:210px; height:50px">Agregar</button></a></th>
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
							<td><button  value="<%=tra.getIdTrabajo() %>" name="IdTrabIn" type="submit" class="button--tabla" style="width:100px; height:35px">Editar</button></td>
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
							<td><button  value="<%=tra.getIdTrabajo() %>" name="IdTrabIn" type="submit" class="button--tabla"  style="width:100px; height:35px">Borrar</button></td>
						</form>
	                </tr>
	                <% } %>
	             </tbody>
	             <form action="servletRedireccionMenuPersonas" method="post" class="login bg-light">
			  		<input class="button--volver" type="submit" value="Volver">
			  	</form>
	             
            </table>
        </section>
        <!-- LA IDEA ES AGREGAR TODOS LOS TOURS -->
    </main>
</body>
</html>