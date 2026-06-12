<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Trabajo"%>
<%@page import="entidades.Persona"%>
<%@page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 		<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js" integrity="sha384-GNFwBvfVxBkLMJpYMOABq3c+d3KnQxudP/mGPkzpZSTYykLBNsZEnG2D9G/X/+7D" crossorigin="anonymous" async></script>
        <link scr="footer.css">
        <%LinkedList<Trabajo> listTrab = (LinkedList<Trabajo>)request.getAttribute("listaTrabajos");%>
        <%Persona user=(Persona)request.getAttribute("persona"); %> 
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
              <form action="/TpJava/servletRedireccionInicio" method="post" >
              	<button value="<%=user.getDni()%>" name="userIn" type="submit" class="btn btn-outline-light" style="width:100%;">ChangasOnline</button>
              </form>
                <i class="fas fa-bars"></i>
              <div class="navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                  	<form action="/TpJava/servletMisChangas" method="post" >
                    	<button value="<%=user.getDni()%>" name="userIn" type="submit" class="btn btn-outline-light" style="width:100%;">Mis changas</button>
                    </form>
                  </li>
                  <li class="nav-item">
                    <form action="/TpJava/servletRedireccionNuevaChanga" method="post" >
                    	<button value="<%=user.getDni()%>" name="userIn" type="submit" class="btn btn-outline-light" style="width:100%;">Nueva Changa</button>
                    </form>
                  </li>
                </ul>
              </div>
              <div class="ms-auto">
        		<form action="/TpJava/index.html" method="get">
          			<button type="submit" class="btn btn-outline-light">Cerrar sesión</button>
        		</form>
      		  </div>
            </div>
          </nav>
    <div class="container">
    <div class="row" data-masonry="{&quot;percentPosition&quot;: true }" style="position: relative; height: 10;">
		<%
		for (Trabajo trab : listTrab) { 
		%>
		<%if(trab.getEstado().equals("pendienteCotizacion")){ %>
		<div class=" col-lg-12 " >
	      <div class="card " style="width: 18rem; width: auto;;">
	          <div class="card-body">
	            <h5 class="card-title text-center"><%=trab.getTitulo() %></h5>
	            <h6 class="card-subtitle mb-2 text-muted "><%=trab.getLocalidad().getDescripcion() %></h6>
             	<p class="card-text" style="width: fit-content"><%=trab.getDescripcion() %></p>
	            <h6>Esperando a que alguien acepte esta changa.</h6>
	                <div class="text-center">
	                  <form action="/TpJava/servletEliminarTrabajos" method="post">
	                  	<input type="hidden" name="userDni" value="<%=user.getDni()%>" />
	                  	<input type="hidden" name="userRol" value="<%=user.getRol().getDescripcion()%>" />
	                    <td><button  value="<%=trab.getIdTrabajo() %>" name="IdTrabIn" type="submit" class="btn btn-danger" style="width:100%; height:35px; ">Cancelar Changa</button></td>
	                  </form>
	                </div>
	              </div>
	            <div class="card-footer text-muted text-center ">
	              <%=trab.getFechaEstimadaIni()%>
            </div>
        </div> 
      </div>
		<%} %>
		<%if(trab.getEstado().equals("cotizadoPendienteConfirmacion")){ %>
		<div class=" col-lg-12 " >
      <div class="card " style="width: 18rem; width: auto;;">
          <div class="card-body">
            <h5 class="card-title text-center"><%=trab.getTitulo() %></h5>
            <table>
              <tr>
              <ul class="list-group list-group-flush">
             
              <h6 class="card-subtitle mb-2 text-muted "><%=trab.getLocalidad().getDescripcion() %></h6>
              <p class="card-text" style="width: fit-content"><%=trab.getDescripcion() %></p>
              
                <th><li class="list-group-item">Fecha de inicio estimada</li></th>
                <th><li class="list-group-item">Fecha de finalización estimada</li></th>
                <th><li class="list-group-item">Precio del trabajo</li></th>
                <th><li class="list-group-item">Observaciones</li></th>
              </ul>
              </tr>

              <ul class="list-group list-group-flush">
                <td><li class="list-group-item"><%=trab.getFechaEstimadaIni() %></li></td>
                <td><li class="list-group-item"><%=trab.getFechaEstimadaFin() %></li></td>
                <td><li class="list-group-item"><%=trab.getPrecioFinal() %></li></td>
                <td ><li class="list-group-item"><%=trab.getObservaciones() %></li></td>

              </ul>
              </tr>
            </tr>
            </table>
                <div class="text-center">
                  <table>
                    <form action="/TpJava/servletModificarTrabajos" method="post">
                      <input type="hidden" name="menuIn" value="persona" />
                      <input type="hidden" name="dniTrabIn" value="<%=trab.getDniTrabajador()%>" />
                      <input type="hidden" name="tituloIn" value="<%=trab.getTitulo()%>" />
                      <input type="hidden" name="descripcionIn" value="<%=trab.getDescripcion()%>" />
                      <input type="hidden" name="dniCliIn" value="<%=trab.getDniCliente()%>" />
                      <input type="hidden" name="estadoIn" value="pendienteCotizacion" />
                      <input type="hidden" name="fechaIniIn" value="" />
                      <input type="hidden" name="fechaFinIn" value="" />
                      <input type="hidden" name="ubiAproxIn" value="<%=trab.getUbicacionAprox()%>" />
                      <input type="hidden" name="fechaEstIniIn" value="<%=trab.getFechaEstimadaIni()%>" />
                      <input type="hidden" name="fechaEstFinIn" value="1990-01-01" />
                      <input type="hidden" name="valIn" value="<%=trab.getValuacionTrabajo()%>" />
                      <input type="hidden" name="precioFin" value="<%=trab.getPrecioFinal()%>" />
                      <input type="hidden" name="obsIn" value="<%=trab.getObservaciones()%>" />
                      <input type="hidden" name="idLocIn" value="<%=trab.getIdLocalidad()%>" />
                      <input type="hidden" name="locIn" value="<%=trab.getLocalidad().getDescripcion()%>" />
                      <input type="hidden" name="userIn" value="<%=user.getDni()%>" />
                        
                      <td ><button  value="<%=trab.getIdTrabajo() %>" name="IdTrabIn" type="submit" class="btn btn-danger" style="width:100px; height:35px">Rechazar</button></td>
                    </form>
                      
                    <form action="/TpJava/servletModificarTrabajos" method="post">
                      <input type="hidden" name="menuIn" value="persona" />
                      <input type="hidden" name="dniTrabIn" value="<%=trab.getDniTrabajador()%>" />
                      <input type="hidden" name="tituloIn" value="<%=trab.getTitulo()%>" />
                      <input type="hidden" name="descripcionIn" value="<%=trab.getDescripcion()%>" />
                      <input type="hidden" name="dniCliIn" value="<%=trab.getDniCliente()%>" />
                      <input type="hidden" name="estadoIn" value="enProceso" />
                      <input type="hidden" name="fechaIniIn" value="" />
                      <input type="hidden" name="fechaFinIn" value="" />
                      <input type="hidden" name="ubiAproxIn" value="<%=trab.getUbicacionAprox()%>" />
                      <input type="hidden" name="fechaEstIniIn" value="<%=trab.getFechaEstimadaIni()%>" />
                      <input type="hidden" name="fechaEstFinIn" value=<%=trab.getFechaEstimadaFin() %> />
                      <input type="hidden" name="valIn" value="<%=trab.getValuacionTrabajo()%>" />
                      <input type="hidden" name="precioFin" value="<%=trab.getPrecioFinal()%>" />
                      <input type="hidden" name="obsIn" value="<%=trab.getObservaciones()%>" />
                      <input type="hidden" name="idLocIn" value="<%=trab.getIdLocalidad()%>" />
                      <input type="hidden" name="locIn" value="<%=trab.getLocalidad().getDescripcion()%>" />
                      <input type="hidden" name="userIn" value="<%=user.getDni()%>" />
                      
                      <td><button  value="<%=trab.getIdTrabajo() %>" name="IdTrabIn" type="submit" class="btn btn-success" style="width:100%; height:35px">Aceptar presupuesto</button></td>
                    </form>
                    <label>Valuación promedio del trabajador: <%=trab.getTrabajador().getValuacionPromedio()%></label>
                  </table>
                </div>
              </div>
            <div class="card-footer text-muted text-center">
              <%=trab.getFechaEstimadaIni()%>
            </div>
        </div> 
      </div>
  	<%} if(trab.getEstado().equals("enProceso")){%>
         <div class=" col-lg-12 " >
      <div class="card border-success" style="width: 18rem; width: auto;;">
          <div class="card-body">
            <h5 class="card-title text-center"><%=trab.getTitulo() %></h5>
            <table>
              <tr>
              <ul class="list-group list-group-flush">
             
              <h6 class="card-subtitle mb-2 text-muted "><%=trab.getLocalidad().getDescripcion() %></h6>
              <p class="card-text" style="width: fit-content"><%=trab.getDescripcion() %></p>
              
                <th><li class="list-group-item border-success">Fecha de inicio estimada</li></th>
                <th><li class="list-group-item border-success">Fecha de finalización estimada</li></th>
                <th><li class="list-group-item border-success">Precio del trabajo</li></th>
                <th><li class="list-group-item border-success">Observaciones</li></th>
              </ul>
              </tr>

              <ul class="list-group list-group-flush">
                <td><li class="list-group-item border-success"><%=trab.getFechaEstimadaIni() %></li></td>
                <td><li class="list-group-item border-success"><%=trab.getFechaEstimadaFin() %></li></td>
                <td><li class="list-group-item border-success"><%=trab.getPrecioFinal() %></li></td>
                <td ><li class="list-group-item border-success"><%=trab.getObservaciones() %></li></td>

              </ul>
              </tr>
            </tr>
            </table>
                <div class="text-center">
                  <table>
                      
                    <form action="ABMCTrabajos/Modificacion/modificarFinalizarTrabajo.jsp" method="post">
                      <input type="hidden" name="dniTrabIn" value="<%=trab.getDniTrabajador()%>" />
                      <input type="hidden" name="tituloIn" value="<%=trab.getTitulo()%>" />
                      <input type="hidden" name="descripcionIn" value="<%=trab.getDescripcion()%>" />
                      <input type="hidden" name="dniCliIn" value="<%=trab.getDniCliente()%>" />
                      <input type="hidden" name="estadoIn" value="<%=trab.getEstado()%>" />
                      <input type="hidden" name="fechaIniIn" value="<%=trab.getFechaIni()%>" />
                      <input type="hidden" name="fechaFinIn" value="<%=trab.getFechaFin()%>" />
                      <input type="hidden" name="ubiAproxIn" value="<%=trab.getUbicacionAprox()%>" />
                      <input type="hidden" name="fechaEstIniIn" value="<%=trab.getFechaEstimadaIni()%>" />
                      <input type="hidden" name="fechaEstFinIn" value="<%=trab.getFechaEstimadaFin()%>" />
                      <input type="hidden" name="valIn" value="<%=trab.getValuacionTrabajo()%>" />
                      <input type="hidden" name="precioFin" value="<%=trab.getPrecioFinal()%>" />
                      <input type="hidden" name="obsIn" value="<%=trab.getObservaciones()%>" />
                      <input type="hidden" name="idLocIn" value="<%=trab.getIdLocalidad()%>" />
                      <input type="hidden" name="locIn" value="<%=trab.getLocalidad().getDescripcion()%>" />
                      <input type="hidden" name="userIn" value="<%=user.getDni()%>" />
                      <td><button  value="<%=trab.getIdTrabajo() %>" name="IdTrabIn" type="submit" class="btn btn-success" style="width:100%; height:35px">Trabajo Finalizado</button></td>
                    </form>
                    <label>Valuación promedio del trabajador: <%=trab.getTrabajador().getValuacionPromedio()%></label>
                  </table>
                </div>
              </div>
            <div class="card-footer text-muted text-center border-success">
              <%=trab.getFechaEstimadaIni()%>
            </div>
        </div> 
      </div>
         
         
         
      <%}%>
		<%}%>
	</div>

  </div>
    <footer class="bg-light text-center text-lg-start fixed-bottom">
  
  		<div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.05)">
    		© 2026 Copyright:
    		<a>ChangasOnline.com</a>
  		</div>
	</footer>
  
  </div>
</body>
</html>