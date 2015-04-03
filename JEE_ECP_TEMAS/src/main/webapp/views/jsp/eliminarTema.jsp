<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="rView" scope="request" value="${eliminarTema}"/>
	<h3>Eliminar Tema</h3>
	
	<form action="/JEE_ECP_TEMAS/jsp/eliminarTema" method="post">
		<p>Tema:
			<select name="idTema" >
				<c:forEach var="tema" items="${rView.temas}">
					<option value="${tema.id}">${tema.nombre}</option>
				</c:forEach>
			</select>
		</p>
		<input type="submit" value="Borrar" />
	</form>
	<a href="/JEE_ECP_TEMAS/jsp/home">Volver a Home</a>
</body>
</html>