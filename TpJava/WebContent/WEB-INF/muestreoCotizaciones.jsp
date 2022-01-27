<%@page import="entidades.Cotizacion"%>
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
		LinkedList<Cotizacion> lc = (LinkedList<Cotizacion>)request.getAttribute("listaCotizaciones");
	%>

<title>Listado de cotizaciones</title>
</head>
<body>
<p class="fs-2 font-monospace" align="center" >Listado de cotizaciones</p>
	<fieldset>
		<div class="container" align="left" >
 			 <div class="row g-4" >
 			 	<div class="col col-md-10">
					<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light">	
					  <thead  class="table-dark">
					    <tr>
					      <th scope="col">Id cotización</th>
					      <th scope="col">Precio por hora</th>
					      <th scope="col">Precio final</th>
					      <th scope="col">Fecha cotización</th>
					      <th scope="col">Descripción</th>
					      <th scope="col">Materiales requeridos</th>
					      <th colspan="2" ><a href="ABMCCotizaciones/Agregar/agregarCotizaciones.html"><button type="button" class=" bot btn btn-light btn-lg"  style="width:210px; height:35px">Agregar</button></a></th>
					    </tr>
					  </thead>  
					  <tbody>
						<% 
						for (Cotizacion cot : lc) { 
						%>
						<tr>
							<td><%=cot.getIdCotizacion() %></td>
							<td><%=cot.getPrecioHora() %></td>
							<td><%=cot.getPrecioFinal() %></td>
							<td><%=cot.getFechaCotizacion() %></td>
							<td><%=cot.getDescripcion() %></td>
							<td><%=cot.getMaterialesRequeridos() %></td>
							
							<form action="ABMCCotizaciones/Modificacion/modificarCotizaciones.jsp" method="get" >
								<input type="hidden" name="PrecioHora" value="<%=cot.getPrecioHora()%>" />
								<input type="hidden" name="PrecioFinal" value="<%=cot.getPrecioFinal()%>" />
								<input type="hidden" name="FechaCot" value="<%=cot.getFechaCotizacion()%>" />
								<input type="hidden" name="Descripcion" value="<%=cot.getDescripcion()%>" />
								<input type="hidden" name="MaterialesReq" value="<%=cot.getMaterialesRequeridos()%>" />
							<td><button  value="<%=cot.getIdCotizacion() %>" name="IdCot" type="submit" class="btn btn-light btn-lg"  style="width:100px; height:35px">Editar</button></td>
						</form>
						
						<form action="ABMCCotizaciones/Eliminar/eliminarCotizaciones.jsp" method="get" >
								<input type="hidden" name="PrecioHora" value="<%=cot.getPrecioHora()%>" />
								<input type="hidden" name="PrecioFinal" value="<%=cot.getPrecioFinal()%>" />
								<input type="hidden" name="FechaCot" value="<%=cot.getFechaCotizacion()%>" />
								<input type="hidden" name="Descripcion" value="<%=cot.getDescripcion()%>" />
								<input type="hidden" name="MaterialesReq" value="<%=cot.getMaterialesRequeridos()%>" />
							<td><button  value="<%=cot.getIdCotizacion() %>" name="IdCot" type="submit" class="btn btn-light btn-lg"  style="width:100px; height:35px">Borrar</button></td>
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