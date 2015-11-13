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
AsObservacionController asObservacionController=(AsObservacionController) context.getBean("AsObservacionController");

AsParametroController asParametroController= (AsParametroController) context.getBean("AsParametroController");

List<AsParametro> list= asParametroController.daAsParametro();

String crear = request.getParameter("crear");
String mensaje;
	if (crear != null && "on".equals(crear)) {
		AsObservacion asObservacion= new AsObservacion();
		asObservacion.setCObservacion(Integer.parseInt(request.getParameter("cObservacion").trim()));
		asObservacion.setDObservacion(request.getParameter("dObservacion").trim());
		asObservacion.setCUsuario(request.getParameter("cUsuario").trim());
		asObservacion.setCMetodo(Integer.parseInt(request.getParameter("cMetodo").trim()));
		asObservacion.setCClase(Integer.parseInt(request.getParameter("cClase").trim()));
		asObservacion.setCAtributo(Integer.parseInt(request.getParameter("cAtributo").trim()));
		asObservacion.setCParametro(Integer.parseInt(request.getParameter("cParametro").trim()));
		//asObservacion.setCObservacion(Integer.parseInt(request.getParameter("cObservacion").trim()));
		asObservacion.setBActivo(Integer.parseInt(request.getParameter("bActivo").trim()));
		boolean existe = asObservacionController.crear(asObservacion);
		if (existe) {
			response.sendRedirect("observacion.jsp");
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
<title>Nueva Observacion</title>
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
			name="frmAddObservacion" role="form">

			<div class="form-group">
				<label for="cObservacion"> ID Observacion :<input
					class="form-control" type="text" id="cObservacion"
					name="cObservacion" value="<c:out value="${AsObservacion.CObservacion}" />" />
				</label>
			</div>
			<div class="form-group">
				<label for="dObservacion"> Descripcion:<input
					class="form-control" type="text" id="dObservacion"
					name="dObservacion" value="<c:out value="${AsObservacion.DObservacion}" />" />
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
			<div class="form-group">
				<label for="dObservacion"> Atributo:<input
					class="form-control" type="text" id="cAtributo"
					name="cAtributo" value="<c:out value="${AsObservacion.CAtributo}" />" />
				</label>
			</div>
			<div class="form-group">
				<label for="parametroid"> Parametro: <select id='cParametro'
					name='cParametro'>
						<c:forEach items="<%=list %>" var="par">
							<option value = "<c:out value="${par.getAsParametroPK().getCParametro()}" />"> <c:out value="${par.getDParametro()}" /> </option>
						</c:forEach>
				</select>
				</label>
			</div>
			<div class="form-group">
				<label for="bActivo"> Activo: <select id = "bActivo"
					name="bActivo">
						<option value = "1">Si</option>
						<option value = "0">No</option>
						
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