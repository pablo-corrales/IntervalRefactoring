<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votaciones</title>
</head>
<body>
	<c:set var="rView" scope="request" value="${votar}"/>
	
	<form action="/JEE_ECP_TEMAS/jsp/votar" method="post">
		<p>Su dirección IP: <input type="text" name="ip" value="${rView.ip}"/>	</p>
		
		<p>Eleja un Tema:
			<select name="idTema" >		
				<c:forEach var="tema" items="${rView.temas}">
					<option value="${tema.id}">${tema.nombre}</option>
					
				</c:forEach>
				
			</select>
			<p>Pregunta: <input type="text" name="pregunta" value="${rView.pregunta}"/>	</p>
					
				
		<p>Ingrese su Nivel de Estudios:
			<select size="${rView.length}" name="estudio">
				<c:forEach var="estudio" items="${rView.nivelEstudios}">
					<option>${estudio}</option>
				</c:forEach>
			</select>
		</p>
		<p>Puntuación de este Tema:
			<select name="puntaje">
				<c:forEach var="punto" items="${rView.puntuacion}">
					<option>${punto}</option>
				</c:forEach>
			</select>
		</p>
		<br><br>
		<input type="submit" value="Registrar votación" />
	</form>
	<br><br>
	<a href="/JEE_ECP_TEMAS/jsp/home">Volver a Home</a>
</body>
</html>