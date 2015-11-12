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
TbTipoMetodo tbTipoMetodo= new TbTipoMetodo();	
String id="";
String isd= "";

	if (crear != null && "on".equals(crear)) {
		
		
		id = request.getParameter("ctipometodo");
		tbTipoMetodo=tbTipoMetodoController.daTbTipoMetodoById(id);		
		tbTipoMetodo.setDTipoMetodo(request.getParameter("dtipometodo"));
		
		boolean existe = tbTipoMetodoController.crear(tbTipoMetodo);
		if (existe) {
			response.sendRedirect("tbtipometodo.jsp");
			mensaje = "Se creo el  departamento";
		} else {
			response.sendRedirect("new.jsp");
			mensaje = "Error al guardar el TbTipoAtributo";
		}
	}else{
		isd = request.getParameter("userId");
		request.setAttribute("TbTipoMetodo", tbTipoMetodoController.daTbTipoMetodoById(isd));
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
		<form method="POST" action='edit.jsp'
			name="frmAddAtributo" role="form">

			<div class="form-group">
				<label for="personid"> Codigo Tipo Metodo: <input
					class="form-control" id="ctipometodo" name="ctipometodo" readonly="readonly"
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
			 	<input type="submit" value="editar"/>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>