<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="entidades.Persona"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js" integrity="sha384-GNFwBvfVxBkLMJpYMOABq3c+d3KnQxudP/mGPkzpZSTYykLBNsZEnG2D9G/X/+7D" crossorigin="anonymous" async></script>
 <link scr="footer.css">
 
<%Persona user=(Persona)request.getAttribute("persona"); %>
<meta charset="ISO-8859-1">
<title>Crear una nueva changa</title>
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




      <div class="mb-3" style="position: sticky; margin: 2%;">
        <form action="/TpJava/servletAgregarTrabajos" method="post">
        <input type="hidden" name="menuIn" value="persona" />
        <%DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();%>
          <input type="hidden" name="fechaEstIniIn" value="<%=dtf.format(now)%>" />
          <input type="hidden" name="estadoIn" value="pendienteCotizacion"/>
		  <div class="form-row">
            <div class="form-group col-md-6">
              <label for="tituloIn">Título</label>
              <input type="text" class="form-control" name="tituloIn" placeholder="Plomero">
            </div>
           <div class="form-group col-md-6">
              <label for="ubiAproxIn">Ubicación</label>
              <input type="text" class="form-control" name="ubiAproxIn" placeholder="Francia 2222">
            </div>
          </div>

			<div class="form-row">
            <div class="form-group col-md-6">
              <label for="idLocIn">Localidad</label>
              <input type="text" class="form-control" name="idLocIn" placeholder="Funes">
            </div>
		  <div class="form-group col-md-6">
            <label for="descripcionIn">Detalle de la changa</label>
            <textarea class="form-control" name="descripcionIn" rows="3"></textarea>
          </div>

          <button value="<%=user.getDni()%>" name="dniCliIn"  type="submit" class="mb-3 btn btn-success" >Crear nueva changa</button>
        
      
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