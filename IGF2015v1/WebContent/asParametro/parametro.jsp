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
AsParametroController asParametroController= (AsParametroController) context.getBean("AsParametroController");
AsParametroPKController asParametroPKController= (AsParametroPKController) context.getBean("AsParametroPKController");

List<AsParametro> list= asParametroController.daAsParametro();
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1"
	name="viewport">
<title>Parametro</title>

<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="bootstrap.css" rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parametro</title>
</head>
<body>
	<div class="wrap">
		<section>
		<div class="container">
		<div class="page-header">
  			<h1>Parámetros</h1>
		</div>
			<table class="table table-hover">

				<thead>
					<tr>
						<th>ID Parametro</th>
						<th>Descripcion</th>
						<th>Tipo Parametro</th>
						<th>Usuario</th>
						<th>Clase</th>
						<th>Metodo</th>
						<th>Fecha Ingreso</th>
						<th colspan=2>Accion</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="<%=list%>" var="obs">
						<tr>
							<td><c:out value="${obs.getAsParametroPK().getCParametro()}" /></td>
							<td><c:out value="${obs.getDParametro()}" /></td>
							<td><c:out value="${obs.getDTipoParametro()}" /></td>
							<td><c:out value="${obs.getCUsuario()}" /></td>
							<td><c:out value="${obs.getAsParametroPK().getCClase()}" /></td>
							<td><c:out value="${obs.getAsParametroPK().getCMetodo()}" /></td>
							<td><c:out value="${obs.getFIngreso()}" /></td>
							<td><a
								href="edit.jsp?Id=<c:out value="${obs.getAsParametroPK().getCParametro()}"/>">Actualizar</a></td>
							<td><a
								href="delete.jsp?Id=<c:out value="${obs.getAsParametroPK().getCParametro()}"/>">Borrar</a></td>
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