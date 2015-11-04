<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="sv.edu.ues.igf115.controller.*"%>
<%@page import="sv.edu.ues.igf115.model.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1"
	name="viewport">
<title>Tipo ASMetodo</title>

<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="bootstrap.css" rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tipo ASMetodo</title>
</head>
<body>
	<div class="wrap">
		<section>
		<div class="container">
			<table class="table table-hover">

				<thead>
					<tr>
						<th>Codigo Clase</th>
						<th>Codigo Metodo</th>
						<th>Descripcion Metodo</th>
						<th>Descripcion Tipo Retorno</th>
						<th>Usuario</th>						
						<th>Fecha</th>
						<th>Activo</th>
						<th>Numero Parametro</th>
						<th>Codigo Tipo Metodo</th>
						<th colspan=2>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lst}" var="user">
						<tr>
							<td><c:out value="${user.asMetodoPK.CClase}" /></td>
							<td><c:out value="${user.asMetodoPK.CMetodo}" /></td>
							<td><c:out value="${user.DMetodo}" /></td>
							<td><c:out value="${user.DTipoRetorno}" /></td>
							<td><c:out value="${user.CUsuario}" /></td>
							<td><fmt:formatDate pattern="dd MMM,yyyy"
									value="${user.FIngreso}" /></td>
						    <td><c:out value="${user.BActivo}" /></td>
						    <td><c:out value="${user.NParametros}" /></td>
						    <td><c:out value="${user.CTipoMetodo.CTipoMetodo}" /></td>
						   
							<td><a
								href="../AsMetodoController?action=edit&userId=<c:out value="${user.asMetodoPK.CMetodo}"/>">Update</a></td>
							<td><a
								href="../AsMetodoController?action=delete&userId=<c:out value="${user.asMetodoPK.CMetodo}"/>">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="../AsMetodoController?action=insert" role="button"
				class="btn btn-info btn-lg" data-toggle="modal">Agregar</a>
		</div>
		</section>
	</div>

	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>