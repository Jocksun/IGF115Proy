<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="org.springframework.context.* , org.springframework.context.support.*, org.springframework.web.context.support.*" %>
<%@page import="sv.edu.ues.igf115.controller.*"%>
<%@page import="sv.edu.ues.igf115.model.*"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.*" %>

<%
ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
AsInterfaceImplementaController AsInterImplementsCtrol=(AsInterfaceImplementaController) context.getBean("AsInterImplementsCtrol");
CtrlAsInterface ctrolAsInte=(CtrlAsInterface) context.getBean("ctrlAsInter");

String crear = request.getParameter("crear");
System.out.println (crear);

if(crear != null && "on".equals(crear)) {
Integer cInterfaceImplementa = Integer.parseInt(request.getParameter("cInterfaceImplementa"));
int c_interface_padre = Short.parseShort(request.getParameter("c_interface_padre"));
int c_interface_hijo = Short.parseShort(request.getParameter("c_interface_hijo"));

boolean existe = AsInterImplementsCtrol.crearAsInterfaceImplementa(cInterfaceImplementa, c_interface_padre, c_interface_hijo);
String mensaje;

	if (existe) {
		response.sendRedirect("listAsInterfaceImplementa.jsp");
		mensaje = "Se creo el  departamento";
	} else {
		response.sendRedirect("nuevoAsInterfaceImplementa.jsp");
		mensaje = "Error al guardar el cliente";
	}
}	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nuevo AsInterface</title>
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
		<form method="POST" action='nuevoAsInterfaceImplementa.jsp' name="frmAddAtributo" role="form">

			<div class="form-group">
				<label for="cInterface">Código: <input
					class="form-control" type="number" id="cInterfaceImplementa" name="cInterfaceImplementa"
					value=<c:out value="${AsInterfaceImplementa.cInterfaceImplementa}" /> />
				</label>
			</div>
			
			<div class="form-group">
				<label for="dInterface">Padre:<input
					class="form-control" type="number" id="c_interface_padre"
					name="c_interface_padre" 
					value="<c:out value="${AsInterfaceImplementa.c_interface_padre}" />" />
				</label>
			</div>
			
			<div class="form-group">
				<label for="cUsuario">Hijo:<input
					class="form-control" type="number" id="c_interface_hijo"
					name="c_interface_hijo" 
					value="<c:out value="${AsInterfaceImplementa.c_interface_hijo}" />" />
				</label>
			</div>
			
			    <input type="hidden" name="crear" value="on"/>
			 <input type="submit" value="Guardar"/>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</body>
</html>