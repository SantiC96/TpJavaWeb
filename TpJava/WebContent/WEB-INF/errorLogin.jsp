<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, user-scalable=no initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	
	<title>Changas online</title>
	<link rel="stylesheet" href="login.css"/>
<title>Inicio de sesi?n</title>

<h2 align="center"><font face="arial" color="red">El DNI o la contrase?a ingresada no pertenece a un usuario activo.</font></h2>
</head>

<body>
	<form action="servletLogin" method="post" class="login bg-light">
		<div class="form-group">
			<font face="arial" size="5">Formulario</font><br>
			<label>DNI</label><br>
			<input class="form-control" type="text" name="DNIlogin" placeholder="Introduzca su DNI">
		</div>
		<div class="form-group">
			<label>Contrase?a</label><br>
			<input class="form-control" type="password" name="ContraseniaLogin" placeholder="Introduzca su Contrase?a">
		</div>		
				<button type="reset" style="width:170px; height:35px">Limpiar</button>
				<button type="submit" style="width: 170px; height: 35px">Enviar</button>
	</form>
</body>
</html>