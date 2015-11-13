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
TbTipoAtributoController tbTipoAtributoController=(TbTipoAtributoController) context.getBean("TbTipoAtributoController");


TbTipoAtributo tbTipoAtributo = null ;

String crear = request.getParameter("crear");


String mensaje;
String id= request.getParameter("id");
String isd="";
String codigo="";
String descripcion="";

	if (crear != null && "yes".equals(crear)) {

		tbTipoAtributo = tbTipoAtributoController.daTipoAtributoById(id);
		
		boolean existe = tbTipoAtributoController.eliminar(tbTipoAtributo);
		 
		if (existe) {
			response.sendRedirect("atributos.jsp");
			mensaje = "Se creo el  departamento";
		} else {
			response.sendRedirect("atributos.jsp");
			mensaje = "Error al guardar el cliente";
		}
	} else if (crear != null && "no".equals(crear)) {
		response.sendRedirect("atributos.jsp");
		
	}else{
		isd = request.getParameter("userId");
		tbTipoAtributo = tbTipoAtributoController.daTipoAtributoById(isd);
		codigo = tbTipoAtributo.getCTipoAtributo();
		descripcion = tbTipoAtributo.getDTipoAtributo();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit AsMetodo</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="Resource/bootstrap.css" rel="stylesheet">

 <script>
    function cambiaDefecto(){
       document.frmAddAtributo.crear.defaultValue = "no";	   
    }  
   </script> 
</head>
<body>
	<div class="container">
	<h1>Eliminar  TbTipoAtributo</h1>
		<form method="POST" action='delete.jsp' name="frmAddAtributo"
			role="form">


			<label for="lab"> Seguro que desea eliminar el registro </label>


			<div class="form-group">
				<label for="personid"> Codigo Atributo: 
				<c:out value="<%=tbTipoAtributo.getCTipoAtributo()%>"  />
				</label>
			</div>
			<div class="form-group">
				<label for="name"> Descripcion Atributo:
				<c:out value="<%=tbTipoAtributo.getDTipoAtributo()%>"  />
				</label>
			</div>
			
			<div class="form-group">
				<label for="name"> Fecha de Ingreso:
				<c:out value="<%=tbTipoAtributo.getFIngreso()%>"  />
				</label>
			</div>
			
			<td></td>
			
			<input type="hidden" id="id" name="id" value=<c:out value="<%=isd%>" /> />
			<input type="hidden" name="crear" value="yes" /> 
			<input type="submit" value="SI"/>
			<input type="submit" value="NO" onclick="cambiaDefecto()"/>
			
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>