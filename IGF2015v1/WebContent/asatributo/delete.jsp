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


AsAtributo asAtributo= null;	

String crear = request.getParameter("crear");


String mensaje;
Integer id= (request.getParameter("id")!=null)? Integer.parseInt(request.getParameter("id")):null ;
Integer isd=null;


	if (crear != null && "yes".equals(crear)) {
		asAtributo = asAtributoController.daAsAtributoById(id);		
		boolean existe = asAtributoController.eliminar(asAtributo);
		 
		if (existe) {
			response.sendRedirect("asatributo.jsp");
			mensaje = "Se creo el  departamento";
		} else {
			response.sendRedirect("asatributo.jsp");
			mensaje = "Error al guardar el cliente";
		}
	} else if (crear != null && "no".equals(crear)) {
		response.sendRedirect("asatributo.jsp");
		
	}else{
		isd = Integer.parseInt(request.getParameter("userId"));
		asAtributo = asAtributoController.daAsAtributoById(isd);
		request.setAttribute("asAtributo", asAtributo);
		
	
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
	 <h1>Eliminar  ASAtributo</h1>
		<form method="POST" action='delete.jsp' name="frmAddAtributo"
			role="form">


			<label for="lab"> Seguro que desea eliminar el registro </label>


			
			<div class="form-group" >
				<label for="clase">Codigo Clase: 	
				<c:out value="<%=asAtributo.getCClase()%>"/>
				</label>
			</div>

			<div class="form-group">
				<label for="codigoAtributo"> Codigo Atributo:
				  <c:out value="<%=asAtributo.getCAtributo()%>"/>
				</label>
			</div>

			<div class="form-group">
				<label for="metodoid"> Codigo Metodo: 
				  <c:out value="<%=asAtributo.getCMetodo()%>"/>
				</label>
			</div>
			<div class="form-group">
				<label for="descripcioAtrib"> Descripcion Atributo: <c:out
						value="<%=asAtributo.getDAtributo()%>" />
				</label>
			</div>

			<div class="form-group">
				<label for="descripcionTipoDatoAtr"> Descripcion Tipo Dato
					Atributo:
					<c:out value="<%=asAtributo.getDTipoDatoAtributo()%>"/>
				</label>
			</div>
			<div class="form-group">
				<label for="usuario"> Usuario:
				<c:out value="<%=asAtributo.getCUsuario()%>"/>
				</label>
			</div>

			<div class="form-group">
				<label for="codTipoAtrib"> Codigo Tipo Atributo:
				<c:out value="<%=asAtributo.getCTipoAtributo()%>"/>
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