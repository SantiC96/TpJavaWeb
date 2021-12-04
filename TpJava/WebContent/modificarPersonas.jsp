<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="modificarVerificacion.jsp" method="post">
		<h1 align="center">Ingrese los nuevos datos de la persona</h1>
		<table border="1" align="center" bgcolor="silver">
			<tr><td align="center"><font face="arial" size="5">DNI</font></td>	<td align="center"><font face="arial" size="5"><%=request.getParameter("DNIin") %></font></td></tr>
			<tr><td align="center"><font face="arial" size="5">Nombre</font></td>	<td align="center"><input type="text" name="nomIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Apellido</font></td>	<td align="center"><input type="text" name="apeIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Teléfono</font></td>	<td align="center"><input type="text" name="telIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Oficio</font></td>	<td align="center"><input type="text" name="ofiIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Area de Trabajo</font></td>	<td align="center"><input type="text" name="areaIn" size="30"></td></tr>
			<tr><td align="center"><font face="arial" size="5">Valuación promedio</font></td>	<td align="center"><input type="text" name="valIn" size="30"></td></tr>
			<tr><td align="center"><button type="reset" style="width:170px; height:35px">Limpiar</button></td>	<td align="center"><button value="<%=request.getParameter("DNIin") %>" name="DNIin" type="submit" style="width: 170px; height: 35px">Enviar</button></td></tr>
		</table>
	</form>



</body>
</html>