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
<body>
	<c:set var="rView" scope="request" value="${verificarEliminacion}"/>

	<form action="/JEE_ECP_TEMAS/jsp/verificarEliminacion" method="post">
		<p>Verificar Borrado:
			<input type="text" name = "identificador"/>
		</p>
		<p>${rView.mensajeBorrado}</p>
		<input type="submit" value="Verificar" />
	</form>
	<a href="/JEE_ECP_TEMAS/jsp/home">Volver a Home</a>
</body>
</body>
</html>