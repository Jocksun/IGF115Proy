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
AsParametroController asParametroController=(AsParametroController) context.getBean("AsParametroController");

AsParametroPKController asParametroPKController= (AsParametroPKController) context.getBean("AsParametroPKController");

//List<AsParametro> list= asParametroController.daAsParametro();

String crear = request.getParameter("crear");
String mensaje = "";
	if (crear != null && "on".equals(crear)) {
		AsParametro asParametro= new AsParametro();
		AsParametroPK asParametroPK= new AsParametroPK();
		asParametroPK.setCClase(Integer.parseInt(request.getParameter("cClase").trim()));
		asParametroPK.setCMetodo(Integer.parseInt(request.getParameter("cMetodo").trim()));
		asParametroPK.setCParametro(Integer.parseInt(request.getParameter("cParametro").trim()));
	
		asParametro.setAsParametroPK(asParametroPK);
		asParametro.setDParametro(request.getParameter("dParametro").trim());
		asParametro.setDTipoParametro(request.getParameter("dTipoParametro").trim());
		asParametro.setCUsuario(request.getParameter("cUsuario").trim());
		
		boolean existe = asParametroController.crear(asParametro);
		if (existe) {
			response.sendRedirect("parametro.jsp");
			mensaje = "Se creo existosamente";
		} else {
			response.sendRedirect("new.jsp");
			mensaje = "Error al guardar";
		}
	} 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nuevo Parametro</title>
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
	<div class="page-header">
  			<h1>Nuevo Parámetro</h1>
		</div>
		<form method="POST" action='new.jsp'
			name="frmAddObservacion" role="form">

			<div class="form-group">
				<label for="cParametro"> Id Parametro:<input
					class="form-control" type="text" id="cParametro"
					name="cParametro" value="<c:out value="${AsObservacion.DObservacion}" />" />
				</label>
			</div>
			<div class="form-group">
				<label for="dParametro"> Descripcion:<input
					class="form-control" type="text" id="dParametro"
					name="dParametro" value="<c:out value="${AsObservacion.DObservacion}" />" />
				</label>
			</div>
			
			<div class="form-group">
				<label for="dTipoParametro"> Tipo de Parametro:<input
					class="form-control" type="text" id="dTipoParametro"
					name="dTipoParametro" value="<c:out value="${AsObservacion.CMetodo}" />" />
				</label>
			</div>
			<div class="form-group">
				<label for="name"> Usuario :<input
					class="form-control" type="text" id="cUsuario"
					name="cUsuario" value="<c:out value="${AsObservacion.getCUsuario()}" />" />
				</label>
			</div>
			<div class="form-group">
				<label for="dObservacion"> Clase:<input
					class="form-control" type="text" id="cClase"
					name="cClase" value="<c:out value="${AsObservacion.CClase}" />" />
				</label>
			</div>
			<div class="form-group">
				<label for="dObservacion"> Metodo:<input
					class="form-control" type="text" id="cMetodo"
					name="cMetodo" value="<c:out value="${AsObservacion.CMetodo}" />" />
				</label>
			</div>
			<input type="hidden" name="crear" value="on"/>
			 <input type="submit" value="Agregar"/>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>