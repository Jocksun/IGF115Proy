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
TbTipoAtributoController tbTipoAtributoController=(TbTipoAtributoController) context.getBean("TbTipoAtributoController");

String crear = request.getParameter("crear");

String mensaje;

	if (crear != null && "on".equals(crear)) {
		TbTipoAtributo tbTipoAtributo= new TbTipoAtributo();
		tbTipoAtributo.setCTipoAtributo(request.getParameter("codigo").trim());
		tbTipoAtributo.setDTipoAtributo(request.getParameter("descripcion").trim());
		
		boolean existe = tbTipoAtributoController.crear(tbTipoAtributo);
		if (existe) {
			response.sendRedirect("atributos.jsp");
			mensaje = "Se creo el  departamento";
		} else {
			response.sendRedirect("new.jsp");
			mensaje = "Error al guardar el TbTipoAtributo";
		}
	} 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nuevo Tipo Atributo</title>
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
		<form method="POST" action='new.jsp'
			name="frmAddAtributo" role="form">

			<div class="form-group">
				<label for="personid"> Codigo Atributo: <input
					class="form-control"  id="codigo" name="codigo" maxlength="2"
					value=<c:out value="${TbTipoAtributo.CTipoAtributo}" /> />
				</label>
			</div>
			<div class="form-group">
				<label for="name"> Descripcion Atributo:<input
					class="form-control" type="text" id="descripcion"
					name="descripcion" value="<c:out value="${TbTipoAtributo.DTipoAtributo}" />" />
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