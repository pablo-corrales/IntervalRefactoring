<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Media de Votos por Nivel de Estudios</title>
</head>
<body>
	<h3>Consulta de Media de Votos por Nivel de Estudios</h3>
		<c:set var="rView" scope="request" value="${consultarMediaVotosPorEstudios}" />
	
			<c:forEach items="${rView.votoEstudios}" var="votoestudios">
    		
        		 Nivel de Estudios:   ${votoestudios.key} ------ Votos Registrados: ${votoestudios.value}
        	<br>
   			</c:forEach>
    		
    
			
		<a href="/JEE_ECP_TEMAS/jsp/home">Volver a Home</a>
</body>
</html>