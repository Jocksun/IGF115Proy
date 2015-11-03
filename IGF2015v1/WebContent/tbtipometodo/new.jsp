<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="sv.edu.ues.igf115.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nuevo Tipo Metodo</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="Resource/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form method="POST" action='TbTipoMetodoController'
			name="frmAddAtributo" role="form">

			<div class="form-group">
				<label for="personid"> Codigo Tipo Metodo: <input
					class="form-control" type="number" id="ctipometodo" name="ctipometodo"
					value=<c:out value="${TbTipoMetodo.CTipoMetodo}" /> />
				</label>
			</div>
			<div class="form-group">
				<label for="name"> Descripcion Tipo Metodo:<input
					class="form-control" type="text" id="dtipometodo"
					name="dtipometodo" value="<c:out value="${TbTipoMetodo.DTipoMetodo}" />" />
				</label>
			</div>

			<input type="Agregar" value="Submit" class="btn btn-info" />
			 <input type="submit" value="Consultar"/>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>