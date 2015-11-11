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
CtrlAsInterface ctrlAsInter=(CtrlAsInterface) context.getBean("ctrlAsInter");
String crear = request.getParameter("crear");
System.out.println (crear);

if(crear != null && "on".equals(crear)) {
String dInterface = request.getParameter("dInterface");
String cUsuario= request.getParameter("cUsuario");
short cInterface = 7;//Short.parseShort(request.getParameter("cInterface"));
Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fIngreso")); 

boolean existe = ctrlAsInter.crearAsInterface(dInterface, cUsuario, fecha);
String mensaje;

	if (existe) {
		response.sendRedirect("listAsInterface.jsp");
		mensaje = "Se creo el  departamento";
	} else {
		response.sendRedirect("nuevoAsInterface.jsp");
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
		<form method="POST" action='nuevoAsInterface.jsp' name="frmAddAtributo" role="form">

			

			<div class="form-group">
				<label for="cInterface">Código: <input
					class="form-control" type="number" id="cInterface" name="cInterface"
					value=<c:out value="${AsInterface.cInterface}" /> />
				</label>
			</div>

			
			<div class="form-group">
				<label for="dInterface">Descripción:<input
					class="form-control" type="text" id="dInterface"
					name="dInterface" 
					value="<c:out value="${AsInterface.dInterface}" />" />
				</label>
			</div>
			
			<div class="form-group">
				<label for="cUsuario">Usuario:<input
					class="form-control" type="text" id="cUsuario"
					name="cUsuario" 
					value="<c:out value="${AsInterface.cUsuario}" />" />
				</label>
			</div>
			
		   <div class="form-group">
				<label for="cUsuario">Fecha:<input
					class="form-control" type="text" id="fIngreso"
					name="fIngreso" 
					value="<c:out value="${AsInterface.fIngreso}" />" />
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