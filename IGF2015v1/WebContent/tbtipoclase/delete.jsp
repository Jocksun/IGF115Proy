<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="sv.edu.ues.igf115.controller.*"%>
     <%@page import="sv.edu.ues.igf115.model.*" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="org.springframework.context.* , org.springframework.context.support.*,org.springframework.web.context.support.*" %>
    
<%
	ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	TbTipoClaseController ctrlDept=(TbTipoClaseController) context.getBean("ctrlDepto");
	/*String crear = request.getParameter("crear");
	System.out.println (crear);
	if(crear != null && "on".equals(crear)) {
	//Integer id = Integer.parseInt(request.getParameter("idDep"));
	String ctipo = request.getParameter("c_tipo_clase");
	//String dtipo = request.getParameter("d_tipo_clase");
	boolean existe = ctrlDept.eliminarDepartamento(ctipo);
	String mensaje;

		if (existe) {
			response.sendRedirect("lista.jsp");
			mensaje = "Se elimino el tipo clase";
		} else {
			response.sendRedirect("nuevo.jsp");
			mensaje = "error al eliminar el tipo de clase";
		}
	}	
	
	*/

	TbTipoClase tbTipoClase = null ;

	String crear = request.getParameter("crear");


	String mensaje;
	String id= "";
	String isd="";
	String codigo="";
	String descripcion="";

		if (crear != null && "yes".equals(crear)) {
			id = request.getParameter("codigo");
			tbTipoClase = ctrlDept.daDepartamentoByID(id);
			boolean existe = ctrlDept.eliminarDepartamento(tbTipoClase);
			 
			if (existe) {
				response.sendRedirect("lista.jsp");
				mensaje = "Se creo el  departamento";
			} else {
				response.sendRedirect("lista.jsp");
				mensaje = "Error al guardar el cliente";
			}
		} else if (crear != null && "no".equals(crear)) {
			response.sendRedirect("lista.jsp");
		}else{
			isd = request.getParameter("userId");
			tbTipoClase = ctrlDept.daDepartamentoByID(isd);
			//codigo = tbTipoClase.getC_tipo_clase();
			//descripcion = tbTipoClase.getD_tipo_clase();
		}
%>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eliminar tipo clase</title>
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
		<form method="POST" action='delete.jsp' name="frmAddAtributo"
			role="form">


			<label for="lab"> Seguro que desea eliminar el registro </label>


			<div class="form-group">
				<label for="personid"> Codigo Atributo: <input
					class="form-control" id="codigo" name="codigo" readonly="readonly"
					value=<c:out value="<%=tbTipoClase.getC_tipo_clase()%>" /> />
				</label>
			</div>
			
			
			
			
			<td></td>
			
			
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