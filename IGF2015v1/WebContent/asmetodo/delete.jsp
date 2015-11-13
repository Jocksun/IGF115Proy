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
AsMetodoController asMetodoController=(AsMetodoController) context.getBean("AsMetodoController");

String crear = request.getParameter("crear");

String mensaje="";
AsMetodo asMetodo = new AsMetodo();
Integer id= null;
Integer isd= null;

id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : null;


	if (crear != null && "yes".equals(crear)) {
		
		asMetodo=asMetodoController.daAsMetodoId(id);
		
		boolean existe = asMetodoController.update(asMetodo);
		
	if (existe) {
		response.sendRedirect("asmetodo.jsp");
		mensaje = "Se creo el  departamento";
		request.setAttribute("mensaje",mensaje);
	} else {
		response.sendRedirect("asmetodo.jsp");
		mensaje = "Error al guardar el TbTipoAtributo";
		request.setAttribute("mensaje", mensaje);
	}
	}	else{
		
		isd = (request.getParameter("userId")!=null)?Integer.parseInt(request.getParameter("userId")):id;
		request.setAttribute("AsMetodo",asMetodo=asMetodoController.daAsMetodoId(isd));
	}
%>

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
<script>
	function cambiaDefecto() {
		document.frmAddAtributo.crear.defaultValue = "no";
	}
</script>
<body>
	<div class="container">
	<h1>Eliminar  ASMetodo</h1>
	    <c:out value="${mensaje}"></c:out>
		<form method="POST" action='delete.jsp'
			name="frmAddAtributo" role="form">

			

			<div class="form-group">
				<label for="codigoMetodo"> Codigo Metodo:
				<c:out value="${AsMetodo.cMetodo}" />
				</label>
			</div>

			
			<div class="form-group">
				<label for="descripcionMetodo"> Descripcion  Metodo:
				<c:out value="${AsMetodo.DMetodo}" />
				</label>
			</div>
			
			<div class="form-group">
				<label for="descripcionTRetorno"> Descripcion Tipo Retorno:
				<c:out value="${AsMetodo.DTipoRetorno}" />
				</label>
			</div>

			<div class="form-group">
				<label for="usuario"> Usuario:
				<c:out value="${AsMetodo.CUsuario}" />
				</label>
			</div>

			<div class="form-group">
				<label for="parametro"> Numero Parametros: <c:out
						value="${AsMetodo.NParametros}" />
				</label>
			</div>

			<div class="form-group">
				<label for="clase"> Codigo Clase:
				<c:out value="${AsMetodo.cClase}" />
				</label>
			</div>


			<div class="form-group">
				<label for="tipoMetodo"> Tipo Metodo:
				<c:out value="${AsMetodo.CTipoMetodo.CTipoMetodo}" />
				</label>
			</div>
			
		    <input type="hidden" id="id" name="id"	value=<c:out value="<%=isd%>" /> />
		   <input type="hidden"	name="crear" value="yes" /> <input type="submit" value="SI" /> 				
		   <input type="submit" value="NO" onclick="cambiaDefecto()" />

		</form>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>