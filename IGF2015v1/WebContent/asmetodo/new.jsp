<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="sv.edu.ues.igf115.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nuevo AsMetodo</title>
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
		<form method="POST" action='AsMetodoController'
			name="frmAddAtributo" role="form">

			<div class="form-group">
				<label for="clase"> Codigo Clase: <select name='clase'>
						<option value="${AsMetodo.asMetodoPK.CClase}" selected>${AsMetodo.asMetodoPK.CClase}</option>
						<c:forEach items="${lstAsClase}" var="clas">
							<option value="${clas.CClase}">${clas.CClase}</option>
						</c:forEach>
				</select>
				</label>
			</div>

			<div class="form-group">
				<label for="codigoMetodo"> Codigo Metodo: <input
					class="form-control" type="number" id="codigoMetodo" name="codigoMetodo"
					value=<c:out value="${AsMetodo.asMetodoPK.CMetodo}" /> />
				</label>
			</div>

			
			<div class="form-group">
				<label for="descripcionMetodo"> Descripcion  Metodo:<input
					class="form-control" type="text" id="descripcionMetodo"
					name="descripcionMetodo" 
					value="<c:out value="${AsMetodo.DMetodo}" />" />
				</label>
			</div>
			
			<div class="form-group">
				<label for="descripcionTRetorno"> Descripcion Tipo Retorno:<input
					class="form-control" type="text" id="descripcionTRetorno"
					name="descripcionTRetorno" 
					value="<c:out value="${AsMetodo.DTipoRetorno}" />" />
				</label>
			</div>

			<div class="form-group">
				<label for="usuario"> Usuario:<input
					class="form-control" type="text" id="usuario"
					name="usuario" 
					value="<c:out value="${AsMetodo.CUsuario}" />" />
				</label>
			</div>

			<div class="form-group">
				<label for="estado"> Estado:<input class="form-control"
					type="number" id="estado" name="estado"
					value="<c:out value="${AsMetodo.BActivo}" />" />
				</label>
			</div>
			
			<div class="form-group">
				<label for="parametro"> Numero Parametros:<input class="form-control"
					type="number" id="parametro" name="parametro"
					value="<c:out value="${AsMetodo.NParametros}" />" />
				</label>
			</div>


<!-- 			<div class="form-group"> -->
<!-- 				<label for="tipoMetodo"> Tipo Metodo: <select name='tipoMetodo'> -->
<%-- 						<option value="${AsMetodo.CTipoMetodo.CTipoMetodo}" selected>${AsMetodo.CTipoMetodo.CTipoMetodo}</option> --%>
<%-- 						<c:forEach items="${lstTbTipoMetodo}" var="metodo"> --%>
<%-- 							<option value="${metodo.cTipoMetodo.CTipoMetodo}">${metodo.cTipoMetodo.CTipoMetodo}</option> --%>
<%-- 						</c:forEach> --%>
<!-- 				</select> -->
<!-- 				</label> -->
<!-- 			</div> -->
			


			<input type="Agregar" value="Submit" class="btn btn-info" />
			 <input type="submit" value="Consultar"/>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>