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


AsObservacion asObservacion = null ;

String eliminar = request.getParameter("eliminar");


String mensaje;
Integer id= Integer.valueOf(request.getParameter("Id"));

String codigo="";
String descripcion="";

String fecha = "";

	if (eliminar != null && "yes".equals(eliminar)) {

		asObservacion = asObservacionController.daObservacionById(id);
		
		boolean existe = asObservacionController.eliminar(asObservacion);
		 
		if (existe) {
			response.sendRedirect("observacion.jsp");
			mensaje = "Se elimino correctamente";
		} else {
			response.sendRedirect("observacion.jsp");
			mensaje = "Error al eliminar";
		}
	} else if (eliminar != null && "no".equals(eliminar)) {
		response.sendRedirect("observacion.jsp");
		
	}else{
		asObservacion = asObservacionController.daObservacionById(id);
		codigo = String.valueOf(asObservacion.getCObservacion());
		descripcion = asObservacion.getDObservacion();
		fecha = String.valueOf(asObservacion.getFIngreso());
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eliminar Observacion</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="Resource/bootstrap.css" rel="stylesheet">

 <script>
    function cambiaDefecto(){
       document.frmDelObservacion.eliminar.defaultValue = "no";	   
    }  
   </script> 
</head>
<body>
	<div class="container">
	<div class="page-header">
  			<h1>Eliminar Observación</h1>
		</div>
		<form method="POST" action='delete.jsp' name="frmDelObservacion"
			role="form">


			<label for="lab"> Seguro que desea eliminar el registro </label>


			<div class="form-group">
				<label for="personid"> Codigo : 
				<c:out value="<%=codigo%>"  />
				</label>
			</div>
			<div class="form-group">
				<label for="name"> Descripcion :
				<c:out value="<%=descripcion%>"  />
				</label>
			</div>
			
			<div class="form-group">
				<label for="name"> Fecha de Ingreso:
				<c:out value="<%=fecha%>"  />
				</label>
			</div>
			
			
			
			<input type="hidden" id="Id" name="Id" value=<c:out value="<%=id%>" /> />
			<input type="hidden" name="eliminar" value="yes" /> 
			<input type="submit" value="SI"/>
			<input type="submit" value="NO" onclick="cambiaDefecto()"/>
			
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>