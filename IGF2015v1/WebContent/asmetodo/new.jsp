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

String mensaje;

	if (crear != null && "on".equals(crear)) {
		

		
		AsMetodo asMetodo = new AsMetodo();
			
		AsClase asclase=asMetodoController.daAsClaseEntidad(Integer.parseInt(request.getParameter("clase")));
		asMetodo.setAsClase(asclase);
		TbTipoMetodo tbTipoMetodo=asMetodoController.daTbTipoMetodoEntidad(Integer.parseInt(request.getParameter("tipoMetodo")));
		asMetodo.setCTipoMetodo(tbTipoMetodo);
		AsMetodoPK asMet= asMetodoController.daAsMetodoPK(Integer.parseInt(request.getParameter("codigoMetodo")),Integer.parseInt(request.getParameter("clase")));
		asMetodo.setAsMetodoPK(asMet);

		asMetodo.setBActivo(new Integer(1));//1 ACtivo
		asMetodo.setCUsuario(request.getParameter("usuario"));
		asMetodo.setDMetodo(request.getParameter("descripcionMetodo"));
		asMetodo.setDTipoRetorno(request.getParameter("descripcionTRetorno"));
		asMetodo.setFIngreso(new Date());
		asMetodo.setNParametros(Integer.parseInt(request.getParameter("parametro")));
		
		boolean existe = asMetodoController.crear(asMetodo);
		if (existe) {
			response.sendRedirect("asmetodo.jsp");
			mensaje = "Se creo el  departamento";
		} else {
			response.sendRedirect("new.jsp");
			mensaje = "Error al guardar el TbTipoAtributo";
		}
	} 
	else{
		
		List<AsClase> lstAsClase= asMetodoController.daAsClase();
		request.setAttribute("lstAsClase", lstAsClase);
 		List<TbTipoMetodo> lstTbTipoMetodo= asMetodoController.daTipoMetodo();
		request.setAttribute("lstTbTipoMetodo", lstTbTipoMetodo);
		
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
<body>
	<div class="container">
		<form method="POST" action='new.jsp'
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
				<label for="parametro"> Numero Parametros:<input class="form-control"
					type="number" id="parametro" name="parametro"
					value="<c:out value="${AsMetodo.NParametros}" />" />
				</label>
			</div>


			<div class="form-group">
				<label for="tipoMetodo"> Tipo Metodo: <select name='tipoMetodo'>
						<option value="${AsMetodo.CTipoMetodo.CTipoMetodo}" selected>${AsMetodo.CTipoMetodo.CTipoMetodo}</option>
						<c:forEach items="${lstTbTipoMetodo}" var="metodo">
							<option value="${metodo.CTipoMetodo}">${metodo.CTipoMetodo}</option>
						</c:forEach>
				</select>
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