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
		<form method="POST" action='TbTipoAtributoController'
			name="frmAddAtributo" role="form">

			<div class="form-group">
				<label for="personid"> Codigo Atributo: <input
					class="form-control" type="number" id="codigo" name="codigo"
					value=<c:out value="${TbTipoAtributo.CTipoAtributo}" /> />
				</label>
			</div>
			<div class="form-group">
				<label for="personid"> Codigo Metodo: <input
					class="form-control" type="number" id="codigo" name="codigo"
					value=<c:out value="${TbTipoAtributo.CTipoAtributo}" /> />
				</label>
			</div>
			
			<div class="form-group">
				<label for="metodoid"> Codigo Metodo: 
							<select name='met'>
									<option value="${AsAtributo.CMetodo}" selected>${AsAtributo.CMetodo}</option>
									<c:forEach items="${lstMetodo}" var="met">										
											<option value="${met.asMetodoPK.CMetodo}">${met.asMetodoPK.CMetodo}</option>										
									</c:forEach>
							</select>
				</label>																			
			</div>
			
			
			<div class="form-group">
				<label for="personid"> Descripcion Atributo: <input
					class="form-control" type="text" id="codigo" name="codigo"
					value=<c:out value="${TbTipoAtributo.CTipoAtributo}" /> />
				</label>
			</div>
			<div class="form-group">
				<label for="name"> Descripcion Tipo Dato Atributo:<input
					class="form-control" type="text" id="descripcion"
					name="descripcion" value="<c:out value="${TbTipoAtributo.DTipoAtributo}" />" />
				</label>
			</div>
			<div class="form-group">
				<label for="name"> Usuario:<input
					class="form-control" type="text" id="descripcion"
					name="descripcion" value="<c:out value="${TbTipoAtributo.DTipoAtributo}" />" />
				</label>
			</div>

			<div class="form-group">
				<label for="personid"> Codigo Tipo Atributo: 
							<select name='role'>
									<option value="${AsAtributo.CTipoAtributo}" selected>${AsAtributo.CTipoAtributo}</option>
									<c:forEach items="${lstAtributo}" var="role">										
											<option value="${role.CTipoAtributo}">${role.CTipoAtributo}</option>										
									</c:forEach>
							</select>
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