<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>A&ntilde;adir Tema</title>
</head>
<body>
	<c:set var="rView" scope="request" value="${addTema}"/>
	<h3>Añadir Tema</h3>
	
	<form action="/JEE_ECP_TEMAS/jsp/addTema" method="post">
		<p>Tema: <input type="text" name="nombre"/>	</p>
		<p>Pregunta: <input type="text" name="pregunta"/> </p>
		<input type="submit" value="Anadir tema" />
	</form>
	<a href="/JEE_ECP_TEMAS/jsp/home">Volver a Home</a>
</body>
</html>