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
TbTipoMetodoController tbTipoMetodoController=(TbTipoMetodoController) context.getBean("TbTipoMetodoController");

request.setAttribute("lst", tbTipoMetodoController.daTbTipoMetodo());
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1"
	name="viewport">
<title>Tipo Metodo</title>

<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="bootstrap.css" rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tipo Metodo</title>
</head>
<body>
	<div class="wrap">
		<section>
		<div class="container">
		<h1>Listado  TBTipoMetodo</h1>
			<table class="table table-hover">

				<thead>
					<tr>
						<th>ID Tipo Metodo</th>
						<th>Descripcion Tipo Metodo</th>
						<th>Fecha</th>
						<th colspan=2>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lst}" var="user">
						<tr>
							<td><c:out value="${user.CTipoMetodo}" /></td>
							<td><c:out value="${user.DTipoMetodo}" /></td>
							<td><fmt:formatDate pattern="dd MMM,yyyy"
									value="${user.FIngreso}" /></td>
							<td><a
								href="edit.jsp?userId=<c:out value="${user.CTipoMetodo}"/>">Update</a></td>
							<td><a
								href="delete.jsp?userId=<c:out value="${user.CTipoMetodo}"/>">Delete</a></td>
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