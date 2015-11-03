<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="sv.edu.ues.igf115.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nuevo AsAtributo</title>
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
		<form method="POST" action='AsAtributoController'
			name="frmAddAsAtributo" role="form">

			<div class="form-group">
				<label for="clase"> Codigo Clase: <select name='clase'>
						<option value="${AsAtributo.CClase}" selected>${AsAtributo.CClase}</option>
						<c:forEach items="${lstAsClase}" var="clas">
							<option value="${clas.CClase}">${clas.CClase}</option>
						</c:forEach>
				</select>
				</label>
			</div>

			<div class="form-group">
				<label for="codigoAtributo"> Codigo Atributo: <input
					class="form-control" type="number" id="codigoAtributo"
					name="codigoAtributo"
					value=<c:out value="${AsAtributo.CAtributo}" /> />
				</label>
			</div>

			<div class="form-group">
				<label for="metodoid"> Codigo Metodo: <select
					name='metodoid'>
						<option value="${AsAtributo.CMetodo}" selected>${AsAtributo.CMetodo}</option>
						<c:forEach items="${lstMetodo}" var="met">
							<option value="${met.asMetodoPK.CMetodo}">${met.asMetodoPK.CMetodo}</option>
						</c:forEach>
				</select>
				</label>
			</div>
			<div class="form-group">
				<label for="descripcioAtrib"> Descripcion Atributo: <input
					class="form-control" type="text" id="descripcioAtrib"
					name="descripcioAtrib"
					value=<c:out value="${AsAtributo.DAtributo}"/> />
				</label>
			</div>

			<div class="form-group">
				<label for="descripcionTipoDatoAtr"> Descripcion Tipo Dato
					Atributo:<input class="form-control" type="text"
					id="descripcionTipoDatoAtr" name="descripcionTipoDatoAtr"
					value="<c:out value="${AsAtributo.DTipoDatoAtributo}" />" />
				</label>
			</div>
			<div class="form-group">
				<label for="usuario"> Usuario:<input class="form-control"
					type="text" id="usuario" name="usuario"
					value="<c:out value="${AsAtributo.CUsuario}" />" />
				</label>
			</div>

			<div class="form-group">
				<label for="codTipoAtrib"> Codigo Tipo Atributo: <select
					name='codTipoAtrib'>
						<option value="${AsAtributo.CTipoAtributo}" selected>${AsAtributo.CTipoAtributo}</option>
						<c:forEach items="${lstAtributo}" var="role">
							<option value="${role.CTipoAtributo}">${role.CTipoAtributo}</option>
						</c:forEach>
				</select>
				</label>
			</div>

			<input type="Agregar" value="Submit" class="btn btn-info" /> <input
				type="submit" value="Consultar" />
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>