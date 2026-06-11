<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<link rel="stylesheet" href="fondos.css"/>
<link rel="stylesheet" href="tablas.css"/>

<title>Modificar Persona</title>
</head>
<body>
<h2 align="center"><font face="arial" color="red">Complete todos los campos correctamente para modificar los datos.</font></h2>
  <h1 align="center">Modificación de una Persona</h1>

  <div class="container">
    <div class="row align-items-start">

      
      <div class="col">
        <table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light table-bordered">
          <tr><td align="center" colspan="2"><font face="arial" size="5">Datos actuales</font></td></tr>
          	<tr><td align="center"><font face="arial" size="5">DNI</font></td><td align="center"><font face="arial" size="5"><font face="arial" size="5"><%=request.getParameter("DNIin") %></font></td></tr> 
			<tr><td align="center"><font face="arial" size="5">Nombre</font></td><td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("nombre") %></label></font> </td></tr> 
			<tr><td align="center"><font face="arial" size="5">Apellido</font></td><td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("apellido") %></label> </font></td></tr> 
			<tr><td align="center"><font face="arial" size="5">Teléfono</font></td> <td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("telefono") %></label></font> </td></tr> 
			<tr><td align="center"><font face="arial" size="5">Rol</font></td> <td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("IdRolIn") %></label> </font></td></tr> 
			<tr><td align="center"><font face="arial" size="5">Valuación promedio</font></td> <td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("valuacion") %></label></font> </td></tr>
        </table>
        <form action="/TpJava/servletPersonas" method="post">
          <button type="submit" class="btn btn-light border border-dark" style="width:170px; height:35px">Cancelar</button>
        </form>
      </div>

      
      <div class="col">
        <form action="modificarVerificacionPers.jsp" method="post">
	    
	    	<input type="hidden" name="DNIin" value="<%=request.getParameter("DNIin")%>" />
	    	<input type="hidden" name="nombre"    value="<%=request.getParameter("nombre") %>" />
		    <input type="hidden" name="apellido"  value="<%=request.getParameter("apellido") %>" />
		    <input type="hidden" name="telefono"  value="<%=request.getParameter("telefono") %>" />
		    <input type="hidden" name="IdRolIn"  value="<%=request.getParameter("IdRolIn") %>" />
		    <input type="hidden" name="valuacion" value="<%=request.getParameter("valuacion") %>" />
				    
          <table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light table-bordered">
            <tr><td align="center" colspan="2"><font face="arial" size="5">Ingrese los nuevos datos</font></td></tr>
            <tr><td align="center"><font face="arial" size="5">DNI</font></td>           <td align="center"><font face="arial" size="5"><%=request.getParameter("DNIin") %></font></td></tr>
            <tr><td align="center"><font face="arial" size="5">Nombre</font></td>        <td align="center"><input type="text" name="nomIn" size="30"></td></tr>
            <tr><td align="center"><font face="arial" size="5">Apellido</font></td>      <td align="center"><input type="text" name="apeIn" size="30"></td></tr>
            <tr><td align="center"><font face="arial" size="5">Teléfono</font></td>      <td align="center"><input type="text" name="telIn" size="30"></td></tr>
            <tr><td align="center"><font face="arial" size="5">Rol</font></td>           <td align="center"><input type="text" name="IdRolIn" size="30"></td></tr>
            <tr><td align="center"><font face="arial" size="5">Valuación promedio</font></td><td align="center"><input type="text" name="valIn" size="30"></td></tr>
            <tr>
              <td align="center"><button type="reset" class="btn btn-light border border-dark" style="width:170px; height:35px">Limpiar</button></td>
              <td align="center"><button value="<%=request.getParameter("DNIin") %>" name="DNIin" type="submit" class="btn btn-light border border-dark" style="width:170px; height:35px">Enviar</button></td>
            </tr>
          </table>
        </form>
      </div>

    </div>
  </div>
</body>
</html>