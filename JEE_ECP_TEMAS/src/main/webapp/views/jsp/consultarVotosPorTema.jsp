<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Votos por Tema</title>
</head>
<body>
	<h3>Consulta de Votos por Tema</h3>
	<c:set var="rView" scope="request" value="${consultaVotosPorTema}" />
	<p>Temas:</p>
		<ul>
			<c:forEach var="tema" items="${rView.temas}">
				<li>${tema.getNombre()}
					<table>
						<tr>
							<th>Número de votos</th>
							
							<c:forEach var="votacion" items="${rView.DatosVotos}">	
								<td>${votacion}</td>
							</c:forEach>
						
						</tr>	
					</table>
				</li>
			</c:forEach>
		</ul>
		<a href="/JEE_ECP_TEMAS/jsp/home">Volver a Home</a>
</body>
</html>