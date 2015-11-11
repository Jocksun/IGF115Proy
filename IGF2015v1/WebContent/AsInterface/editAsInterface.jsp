<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="sv.edu.ues.igf115.controller.*"%>
<%@page import="sv.edu.ues.igf115.model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="org.springframework.context.* , org.springframework.context.support.*, org.springframework.web.context.support.*" %>

<%
ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
CtrlAsInterface ctrolAsInte=(CtrlAsInterface) context.getBean("ctrlAsInter");

String crear = request.getParameter("crear");

AsInterface asInterface = null;

String mensaje;
short id= 0;
short isd=0;
short codigo=0;
String descripcion="";
String usuario="";
Date fecha;

	if (crear != null && "on".equals(crear)) {
		id = Short.parseShort(request.getParameter("codigo"));		
		asInterface = ctrolAsInte.daAsInterfaceById(id);
		asInterface.setD_interface(request.getParameter("descripcion"));
		asInterface.setC_usuario(request.getParameter("usuario"));
		fecha = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha")); 
		asInterface.setfIngreso(fecha);
		boolean existe = ctrolAsInte.update(asInterface);
		if (existe) {
			response.sendRedirect("listAsInterface.jsp");
			mensaje = "Se creo el  departamento";
		} else {
			response.sendRedirect("editAsInterface.jsp?userId=<c:out value="+id+"");
			mensaje = "Error al guardar el TbTipoAtributo";
		}
	} else {
		isd = Short.parseShort(request.getParameter("userId"));
		asInterface= ctrolAsInte.daAsInterfaceById(isd);
		codigo = asInterface.getC_interface();
		descripcion = asInterface.getD_interface();
		usuario = asInterface.getC_usuario();
		fecha = asInterface.getfIngreso();
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar TbTipoAtributo</title>
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
		<form method="POST" action='editAsInterface.jsp'
			name="frmAddAtributo" role="form">

			<div class="form-group">
				<label for="personid"> Código: <input
					class="form-control" id="codigo" name="codigo" readonly="readonly"
					value=<c:out value="<%=asInterface.getC_interface()%>" /> />
				</label>
			</div>
			<div class="form-group">
				<label for="name"> Descripción:<input
					class="form-control" type="text" id="descripcion"
					name="descripcion" value="<c:out value="<%=asInterface.getD_interface()%>" />" />
				</label>
			</div>
			<div class="form-group">
				<label for="name"> Usuario:<input
					class="form-control" type="text" id="usuario"
					name="usuario" value="<c:out value="<%=asInterface.getC_usuario()%>" />" />
				</label>
			</div>
			<div class="form-group">
				<label for="name"> Fecha:<input
					class="form-control" type="text" id="fecha"
					name="fecha" value="<c:out value="<%=asInterface.getfIngreso()%>" />" />
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