<%@page import="entidades.Cotizacion"%>
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

<%Cotizacion cot = (Cotizacion)request.getAttribute("cotizacion"); %>

<title>Datos de la cotizaci�n</title>
</head>
<body>
<p class="fs-2 font-monospace" align="center" >Datos de la cotizaci�n #<%=cot.getIdCotizacion()%></p>
	<fieldset>
		<div class="container" align="left" >
 			<div class="row g-4" >
 			 	<div class="col col-md-10">
					<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light">	
		  				<thead class="table-dark">
		    				<tr>
		      				 <th scope="col">Id cotizaci�n</th>
					     	 <th scope="col">Precio por hora</th>
					      	 <th scope="col">Precio final</th>
					      	 <th scope="col">Fecha cotizaci�n</th>
					      	 <th scope="col">Descripci�n</th>
					      	 <th scope="col">Materiales requeridos</th>
		    				</tr>
		  				</thead>
		  				<tbody>
							<tr>
							 <td><%=cot.getIdCotizacion() %></td>
							 <td><%=cot.getPrecioHora() %></td>
							 <td><%=cot.getPrecioFinal() %></td>
							 <td><%=cot.getFechaCotizacion() %></td>
							 <td><%=cot.getDescripcion() %></td>
							 <td><%=cot.getMaterialesRequeridos() %></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col">
			  		<form action="/TpJava/servletRedireccionMenuPersonas" method="post" class="login bg-light">
						<button type="submit" class="btn btn-light btn-lg" style="width:100px; height:35px">Volver</button>
					</form>
				</div>
			</div>
		</div>
	</fieldset>
</body>
</html>