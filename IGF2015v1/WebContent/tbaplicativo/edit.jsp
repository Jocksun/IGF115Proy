<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="sv.edu.ues.igf115.controller.*"%>
    <%@page import="java.text.SimpleDateFormat"%>
     <%@page import="sv.edu.ues.igf115.model.*" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="org.springframework.context.* , org.springframework.context.support.*, org.springframework.web.context.support.*" %>
    
    <%
ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
TbAplicativoController ctrlDept=(TbAplicativoController) context.getBean("ctrlApli");
String crear = request.getParameter("crear");
System.out.println (crear);

TbAplicativo tbAplicativo = null;

String mensaje;
String id="";
String isd="";
String codigo="";
String descripcion="";

	if (crear != null && "on".equals(crear)) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		id = request.getParameter("codigo");		
		tbAplicativo = ctrlDept.daDepartamentoByID(id);
		tbAplicativo.setD_aplicativo(request.getParameter("d_aplicativo"));
		//java.util.Date fecha = formatter.parse(request.getParameter("fecha"));
		tbAplicativo.setF_ingreso(formatter.parse(request.getParameter("f_ingreso")));
 
		boolean existe = ctrlDept.modificarDepartamento(tbAplicativo);
		
		if (existe) {
			response.sendRedirect("lista.jsp");
			mensaje = "Se modificio el aplicativo";
		} else {
			response.sendRedirect("edit.jsp?userId=<c:out value="+id+"");
			mensaje = "Error al modificar el aplicativo";
		}
	} else {
		isd = request.getParameter("userId");
		tbAplicativo = ctrlDept.daDepartamentoByID(isd);
		//codigo = tbTipoClase.getC_tipo_clase();
		//descripcion = tbTipoClase.getD_tipo_clase();
	}




%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Aplicativo</title>
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
		<form method="POST" action='edit.jsp' name="frmAddAtributo" role="form">

			
			
			<div class="form-group">
				<label for="personid"> Codigo Aplicativo: <input
					class="form-control" id="codigo" name="codigo" readonly="readonly"
					value=<c:out value="<%=tbAplicativo.getC_aplicativo()%>" /> />
				</label>
			</div>
			
			
			<div class="form-group">
				<label for="d_aplicativo"> nombre aplicativo:<input
					class="form-control" type="text" id="d_aplicativo"
					name="d_aplicativo" 
					value="<c:out value="${tb_aplicativo.getD_aplicativo()}" />" />
				</label>
			</div>
			
			<div class="form-group">
				<label for="f_ingreso"> fecha de ingreso:<input
					class="form-control" type="text" id="f_ingreso"
					name="f_ingreso" 
					value="<c:out value="${tb_aplicativo.f_ingreso}" />" />
				</label>
			</div>
			
			
			    <input type="hidden" name="crear" value="on"/>
			 <input type="submit" value="Modificar"/>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>