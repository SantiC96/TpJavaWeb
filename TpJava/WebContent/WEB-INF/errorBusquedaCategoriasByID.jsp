<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Busqueda de categorias por ID</title>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<link rel="stylesheet" href="fondos.css"/>

<h2 align="center"><font face="arial" color="red">El ID ingresado no pertenece a una categoria existente.</font></h2>
<p align="center"><font face="arial" size="5">ID a buscar</font></p>

</head>
<body>
<div class="container" align="left">
	<div class="row align-items-start">
		<div class="col col-md-10">
			<form action="servleCategoriasByID" method="post">
				<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light">
					<tr><td align="center"><font face="arial" size="5">ID</font></td>	<td align="center"><input type="text" name="IdCatIn" size="30"></td></tr>
					<tr><td align="center"><button type="reset" style="width:170px; height:35px">Limpiar</button></td>	<td align="center"><button type="submit" style="width: 170px; height: 35px">Enviar</button></td></tr>
				</table>
			</form>
		</div>
		
	<div class="col">
		<form action="servletRedireccionMenuPersonas" method="post" class="login bg-light">
			<button type="submit" class="btn btn-light btn-lg" style="width:100px; height:35px">Volver</button>
		</form>
	</div>
	</div>
</div>
</body>
</html>