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
AsParametroController asParametroController= (AsParametroController) context.getBean("AsParametroController");

//List<AsParametro> list= asParametroController.daAsParametro();

String crear = request.getParameter("crear");
AsParametro asParametro = null;

String mensaje;
int id;
String isd="";
String codigo="";
String descripcion="";

	if (crear != null && "on".equals(crear)) {
		id = Integer.parseInt(request.getParameter("codigo"));		
		asParametro = asParametroController.daAsParametro(id);
		asParametro.setDParametro(request.getParameter("descripcion"));
		asParametro.setDTipoParametro(request.getParameter("dTipoParametro"));
		asParametro.setCUsuario(request.getParameter("usuario"));
		boolean existe = asParametroController.update(asParametro);
		if (existe) {
			response.sendRedirect("parametro.jsp");
			mensaje = "Actualizado";
		} else {
			response.sendRedirect("edit.jsp?Id=<c:out value="+id+"");
			mensaje = "Error Actualizar";
		}
	} else {
		id = Integer.parseInt(request.getParameter("Id"));
		asParametro = asParametroController.daAsParametro(id);
		codigo = String.valueOf(asParametro.getAsParametroPK().getCParametro());
		descripcion = asParametro.getDParametro();
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Parámetro</title>
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
  			<h1>Editar Parámetro</h1>
		</div>
		<form method="POST" action='edit.jsp'
			name="frmAddAtributo" role="form">

			<div class="form-group">
				<label for="personid"> Codigo: <input
					class="form-control" id="codigo" name="codigo" readonly="readonly"
					value=<c:out value="<%=asParametro.getAsParametroPK().getCParametro()%>" /> />
				</label>
			</div>
			<div class="form-group">
				<label for="name"> Descripcion :<input
					class="form-control" type="text" id="descripcion"
					name="descripcion" value="<c:out value="<%=asParametro.getDParametro()%>" />" />
				</label>
			</div>
			<div class="form-group">
				<label for="dTipoParametro"> Tipo de Parametro:<input
					class="form-control" type="text" id="dTipoParametro"
					name="dTipoParametro" value="<c:out value="<%=asParametro.getDTipoParametro()%>" />" />
				</label>
			</div>
			<div class="form-group">
				<label for="name"> Usuario :<input
					class="form-control" type="text" id="usuario"
					name="usuario" value="<c:out value="<%=asParametro.getCUsuario()%>" />" />
				</label>
			</div>
			 <input type="hidden" name="crear" value="on"/>
			 <input type="submit" value="Update"/>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>