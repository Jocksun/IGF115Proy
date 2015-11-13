<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="sv.edu.ues.igf115.controller.*"%>
<%@page import="sv.edu.ues.igf115.model.*"%>
<%@page import="java.util.*"%>
<%@page import="org.springframework.context.* , org.springframework.context.support.*, org.springframework.web.context.support.*" %>


<%
ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
AsObservacionController asObservacionController= (AsObservacionController) context.getBean("AsObservacionController");

List<AsObservacion> list= asObservacionController.daAsObservaciones();
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1"
	name="viewport">
<title>Observacion</title>

<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="bootstrap.css" rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Observacion</title>
</head>
<body>
	<div class="wrap">
		<section>
		<div class="container">
			<table class="table table-hover">

				<thead>
					<tr>
						<th>ID Observacion</th>
						<th>Observacion</th>
						<th>Usuario</th>
						<th>Fecha Ingreso</th>
						<th>Activo</th>
						<th>Clase</th>
						
						<th>Atributo</th>
						<th>Metodo</th>
						<th>Parametro</th>
						<th colspan=2>Accion</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="<%=list%>" var="obs">
						<tr>
							<td><c:out value="${obs.CObservacion}" /></td>
							<td><c:out value="${obs.DObservacion}" /></td>
							<td><c:out value="${obs.CUsuario}" /></td>
							<td><fmt:formatDate pattern="dd MMM,yyyy"
									value="${obs.FIngreso}" /></td>
							<td><c:out value="${obs.BActivo}" /></td>
							<td><c:out value="${obs.CClase}" /></td>
							<td><c:out value="${obs.CAtributo}" /></td>
							<td><c:out value="${obs.CMetodo}" /></td>
							<td><c:out value="${obs.asParametro.getDParametro()}" /></td>
							<td><a
								href="edit.jsp?Id=<c:out value="${obs.CObservacion}"/>">Actualizar</a></td>
							<td><a
								href="delete.jsp?Id=<c:out value="${obs.CObservacion}"/>">Borrar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		<p><a href="new.jsp">Agregar</a></p>
		</div>
		</section>
	</div>

	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>