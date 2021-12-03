<%@page import="entidades.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%Persona per = (Persona)request.getAttribute("persona"); %>

<title>Eliminar persona</title>
</head>
<body>
Persona eliminado con exito.
</body>
</html>