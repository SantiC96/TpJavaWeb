<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Trabajo"%>
<%@page import="entidades.Persona"%>
<%@page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>
    <head>
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

    <div class="row" data-masonry="{&quot;percentPosition&quot;: true }" style="position: relative; height: 1990px;">

		<%
		for (Trabajo trab : listTrab) { 
		%>
		<div class="col-sm-6 col-lg-3 mb-3" style="position: absolute; left: 0%; top: 0px;">
                <div class="card" style="width: 18rem; width: auto;;">
                    <div class="card-body">
                        <h5 class="card-title text-center"><%=trab.getTitulo()%></h5>
                        <h6 class="card-subtitle mb-2 text-muted "><%=trab.getLocalidad().getDescripcion()%></h6>
                        <p class="card-text" style="width: fit-content"><%=trab.getDescripcion()%></p>
	                        <div class="text-center">
	                        	<form action="ABMCTrabajos/Inscripcion/inscripcionTrabajo.jsp" method="get" >
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
									<td><button  value="<%=trab.getIdTrabajo() %>" name="IdTrabIn" type="submit" class="btn btn-primary" style="width:100px; height:35px">Inscribirse</button></td>
								</form>
							
								</div>
	                    	</div>
                    <div class="card-footer text-muted text-center">
                        <%=trab.getFechaEstimadaIni()%>
                    </div>
                </div> 
            </div>
		<%}%>
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