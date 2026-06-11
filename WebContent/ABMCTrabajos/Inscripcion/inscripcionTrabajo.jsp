<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Persona"%>
<!DOCTYPE html>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
      <script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js" integrity="sha384-GNFwBvfVxBkLMJpYMOABq3c+d3KnQxudP/mGPkzpZSTYykLBNsZEnG2D9G/X/+7D" crossorigin="anonymous" async></script>
      
    <%Persona user=new Persona (); %>
    <%user.setDni(Integer.parseInt(request.getParameter("userIn"))); %>
    
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


      <div class="row" data-masonry="{&quot;percentPosition&quot;: true }" style="position: relative; height: 1990px;"></div>
        <div  style="position: relative; margin: 2%;">
          <div class="card" style="width: 18rem; width: auto;;">
              <div class="card-body">
                  <h5 class="card-title text-center"><%=request.getParameter("tituloIn")%></h5>
                  <h6 class="card-subtitle mb-2 text-muted "><%=request.getParameter("locIn")%></h6>
                  <p class="card-text" style="width: fit-content"><%=request.getParameter("descripcionIn")%></p>
              </div>
              <div class="card-footer text-muted text-center">
                  <%=request.getParameter("fechaEstIniIn")%>
              </div>
          </div> 
        </div>
      </div>

      <div class="mb-3" style="position: sticky; margin: 2%;">
        <form action="/TpJava/servletModificarTrabajos" method="post">
          <input type="hidden" name="IdTrabIn" value="<%=request.getParameter("IdTrabIn")%>" />
          <input type="hidden" name="dniCliIn" value="<%=request.getParameter("dniCliIn")%>" />
          <input type="hidden" name="dniTrabIn" value="<%=request.getParameter("userIn")%>" />
          <input type="hidden" name="tituloIn" value="<%=request.getParameter("tituloIn")%>" />
          <input type="hidden" name="tituloIn" value="<%=request.getParameter("locIn")%>" />
          <input type="hidden" name="descripcionIn" value="<%=request.getParameter("descripcionIn")%>" />
          <input type="hidden" name="dniCliIn" value="<%=request.getParameter("dniCliIn")%>" />
          <input type="hidden" name="estadoIn" value="cotizadoPendienteConfirmacion" />
          <input type="hidden" name="ubiAproxIn" value="<%=request.getParameter("ubiAproxIn")%>" />
          <input type="hidden" name="idLocIn" value="<%=request.getParameter("idLocIn")%>" />
          <input type="hidden" name="menuIn" value="persona" />
          
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="fechaEstIniIn">Fecha de inicio estimada</label>
              <input type="date" class="form-control" name="fechaEstIniIn" >
            </div>
            <div class="form-group col-md-6">
              <label for="fechaEstFinIn">Fecha de finalizacion estimada</label>
              <input type="date" class="form-control" name="fechaEstFinIn">
            </div>
          </div>
          
    
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="precioFin">Precio del trabajo</label>
              <input type="text" class="form-control" name="precioFin" placeholder="1500.20">
            </div>
          </div>

          <div class="form-group">
            <label for="obsIn">Observaciones</label>
            <textarea class="form-control" name="obsIn" rows="3"></textarea>
          </div>

          <button type="submit" class="mb-3 btn btn-success" >Enviar Cotización</button>
        
      
      </form>
    </div>
    <footer class="bg-light text-center text-lg-start fixed-bottom">
  		<div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.05)">
    		© 2026 Copyright:
    		<a>ChangasOnline.com</a>
  		</div>
	</footer>
  </body>
</html>