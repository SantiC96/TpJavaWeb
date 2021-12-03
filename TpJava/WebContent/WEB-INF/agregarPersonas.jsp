<%@page import="entidades.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%Persona per = (Persona)request.getAttribute("persona"); %>
<title>Agregar nueva persona</title>
</head>
<body>
El usuario <%=per.getNombre() %> <%=per.getApellido()%> fue agregado exitosamente.
<td scope="col" align="center""><a href="menuPersonas.html"><button type="button" class="btn btn-light"  style="width:100px; height:35px;r">Volver</button></a></td>
</body>
</html>