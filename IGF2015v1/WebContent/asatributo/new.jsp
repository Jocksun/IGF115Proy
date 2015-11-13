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
AsAtributoController asAtributoController=(AsAtributoController) context.getBean("AsAtributoController");

String crear = request.getParameter("crear");

String mensaje;

	if (crear != null && "on".equals(crear)) {
		
		AsAtributo asAtributo= new AsAtributo();
		
		asAtributo.setCAtributo(Integer.parseInt(request.getParameter("codigoAtributo")));
		asAtributo.setCClase(Integer.parseInt(request.getParameter("clase")));
		asAtributo.setCMetodo(Integer.parseInt(request.getParameter("metodoid")));		
		asAtributo.setCTipoAtributo(request.getParameter("codTipoAtrib"));
		asAtributo.setCUsuario(request.getParameter("usuario"));
		asAtributo.setDAtributo(request.getParameter("descripcioAtrib"));
		asAtributo.setDTipoDatoAtributo(request.getParameter("descripcionTipoDatoAtr"));
		
		
		boolean existe = asAtributoController.crear(asAtributo);
		if (existe) {
			response.sendRedirect("asatributo.jsp");
			mensaje = "Se creo el  departamento";
		} else {
			response.sendRedirect("new.jsp");
			mensaje = "Error al guardar el TbTipoAtributo";
		}
	} 
	else{
		
		List<AsMetodo> lstMetodo= asAtributoController.daAsMetodo();
		request.setAttribute("lstMetodo", lstMetodo);
		List<TbTipoAtributo> lstAtributo= asAtributoController.daTipoAtributo();
		request.setAttribute("lstAtributo", lstAtributo);
		
	}
%>

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
	   <h1>Nuevo  ASAtributo</h1>
		<form method="POST" action='new.jsp'
			name="frmAddAsAtributo" role="form">

					
			<div class="form-group">
				<label for="clase">Codigo Clase: <input
					class="form-control" type="number" id="clase"
					name="clase"
					value="" />
				</label>
			</div>

			<div class="form-group">
				<label for="codigoAtributo"> Codigo Atributo: <input
					class="form-control" type="number" id="codigoAtributo"
					name="codigoAtributo"
					value="" />
				</label>
			</div>

			<div class="form-group">
				<label for="metodoid"> Codigo Metodo: <select
					name='metodoid'>
						<option value="${AsAtributo.CMetodo}" selected>${AsAtributo.CMetodo}</option>
						<c:forEach items="${lstMetodo}" var="met">
							<option value="${met.cMetodo}">${met.cMetodo}</option>
						</c:forEach>
				</select>
				</label>
			</div>
			<div class="form-group">
				<label for="descripcioAtrib"> Descripcion Atributo: <input
					class="form-control" type="text" id="descripcioAtrib"
					name="descripcioAtrib"
					value=""/>
				</label>
			</div>

			<div class="form-group">
				<label for="descripcionTipoDatoAtr"> Descripcion Tipo Dato
					Atributo:<input class="form-control" type="text"
					id="descripcionTipoDatoAtr" name="descripcionTipoDatoAtr"
					value="" />
				</label>
			</div>
			<div class="form-group">
				<label for="usuario"> Usuario:<input class="form-control"
					type="text" id="usuario" name="usuario"
					value="" />
				</label>
			</div>

			<div class="form-group">
				<label for="codTipoAtrib"> Codigo Tipo Atributo: <select
					name='codTipoAtrib'>
						<option value="${AsAtributo.CTipoAtributo}" selected>${AsAtributo.CTipoAtributo}</option>
						<c:forEach items="${lstAtributo}" var="role">
							<option value="${role.CTipoAtributo}">${role.CTipoAtributo}</option>
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