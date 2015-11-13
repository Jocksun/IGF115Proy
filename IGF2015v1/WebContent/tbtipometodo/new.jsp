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


String crear = request.getParameter("crear");

String mensaje;

	if (crear != null && "on".equals(crear)) {
		
		TbTipoMetodo tbTipoMetodo= new TbTipoMetodo();
		
		tbTipoMetodo.setCTipoMetodo(request.getParameter("ctipometodo"));
		tbTipoMetodo.setDTipoMetodo(request.getParameter("dtipometodo"));
		
		boolean existe = tbTipoMetodoController.crear(tbTipoMetodo);
		if (existe) {
			response.sendRedirect("tbtipometodo.jsp");
			mensaje = "Se creo el  departamento";
			request.setAttribute("mensaje",mensaje);
		} else {
			response.sendRedirect("new.jsp");
			mensaje = "Error al guardar el TbTipoAtributo";
			request.setAttribute("mensaje",mensaje);
		}
	} 
%>

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
	<h1>Nuevo Tipo Metodo</h1>
	    <c:out value="${mensaje}"></c:out>
		<form method="POST" action='new.jsp'
			name="frmAddAtributo" role="form">

			<div class="form-group">
				<label for="personid"> Codigo Tipo Metodo: <input maxlength="1"
					class="form-control" id="ctipometodo" name="ctipometodo"
					value=<c:out value="${TbTipoMetodo.CTipoMetodo}" /> />
				</label>
			</div>
			<div class="form-group">
				<label for="name"> Descripcion Tipo Metodo:<input
					class="form-control" type="text" id="dtipometodo"
					name="dtipometodo" value="<c:out value="${TbTipoMetodo.DTipoMetodo}" />" />
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