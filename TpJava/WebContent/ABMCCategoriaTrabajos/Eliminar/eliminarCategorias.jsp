<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Eliminar</title>
<link rel="stylesheet" href="../fondos.css"/>
<h1 align="center">�Desea eliminar la siguiente categoria?</h1>
</head>
<body>
<form action="/TpJava/servletEliminarCategorias" method="post" >
	<div class="container" align="left">
		<div class="row align-items-start">
			<table class="table table-hover table-striped table-sm border-secondary border border-5 rounded-3 bg-light table-bordered" >
				<tr><td align="center" colspan="2"><lavel><font face="arial" size="5">Datos actuales</font></lavel></td></tr>
				<tr><td align="center"><font face="arial" size="5">ID Categoria</font></td>		<td align="center"><font face="arial" size="5"><font face="arial" size="5"><%=request.getParameter("IdCatIn") %></font></td></tr>
				<tr><td align="center"><font face="arial" size="5">Nombre</font></td>			<td align="center"><font face="arial" size="5"><label size="30"><%=request.getParameter("descIn") %></label></font> </td></tr>
			</table>
		<div class="row">
			<div class="col">
				<button value="<%=request.getParameter("IdCatIn") %>" name="IdCatIn" type="submit" style="width:170px; height:35px">Aceptar</button>
			</div>
</form>
			<div class="col">	
				<form action="/TpJava/servletCategorias" method="post" class="login bg-light">
					<button type="submit" style="width:170px; height:35px">Cancelar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>