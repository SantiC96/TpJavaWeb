<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="menuAdmin.css"/>
  <meta charset="ISO-8859-1">
  <title>Menu Admin</title>
  </head>

  <body>
    <h1 align="center">Menu general para admins</h1>
      <div class="box">
        <form action="servletPersonas" method="post">
          <br><button type="submit" class="btn btn-light border border-dark">Listado general de personas</button></br>
        </form>
        
        <form action="ABMCPersonas/Buscar/busquedaPersonas.html" method="post">
        <form action="busquedaPersonas.html">
          <br><button type="submit" class="btn btn-light border border-dark">Buscar persona por DNI</button></br>
        </form>
        
        <form action="servletTrabajos" method="post">
          <br><button type="submit" class="btn btn-light border border-dark">Listado general de trabajos</button></br>
        </form>
        
        <form action="ABMCTrabajos/Buscar/busquedaTrabajos.html" method="post">
        <form action="busquedaTrabajos.html">
          <br><button type="submit" class="btn btn-light border border-dark">Buscar trabajo por ID</button></br>
        </form>
        
        <form action="servletRoles" method="post">
          <br><button type="submit" class="btn btn-light border border-dark">Listado general de roles</button></br>
        </form>
        
        <form action="ABMCRoles/Buscar/buscarRoles.html" method="post">
        <form action="buscarRoles.html">
          <br><button type="submit" class="btn btn-light border border-dark">Buscar roles por ID</button></br>
        </form>
        
        <form action="servletDirecciones" method="post">
          <br><button type="submit" class="btn btn-light border border-dark">Listado general de direcciones</button></br>
        </form>
        
        <form action="ABMCDirecciones/Buscar/busquedaDirecciones.html" method="post">
        <form action="busquedaDirecciones.html">
          <br><button type="submit" class="btn btn-light border border-dark">Buscar direcciones por calle</button></br>
        </form>
        
        <form action="servletLocalidades" method="post">
          <br><button type="submit" class="btn btn-light border border-dark">Listado general de localidades</button></br>
        </form>
        
        <form action="ABMCLocalidades/Buscar/busquedaLocalidades.html" method="post">
        <form action="busquedaLocalidades.html">
          <br><button type="submit" class="btn btn-light border border-dark">Buscar localidad</button></br>
        </form>
        
        <form action="servletProvincias" method="post">
          <br><button type="submit" class="btn btn-light border border-dark">Listado general de provincias</button></br>
        </form>
        
        <form action="ABMCProvincias/Buscar/buscarProvincias.html" method="post">
        <form action="busquedaProvincias.html">
          <br><button type="submit" class="btn btn-light border border-dark">Buscar provincia</button></br>
        </form>
        
        </h1>
        <br><p align="center"><font face="arial" size="3"><a href="index.html">Volver al inicio</a></font></p></br>
    </div>
  </body>
</html>