<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sv.edu.ues.igf115.controller.*" %>
    <%@ page import="sv.edu.ues.igf115.controller.*"%>
<%@ page import="sv.edu.ues.igf115.model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.math.BigDecimal"%>
<%
   // int idd = Integer.parseInt(request.getParameter("idDep"));
    int cInterface = Integer.parseInt(request.getParameter("cInterface"));
    String dInterface = request.getParameter("dInterface");
    String cUsuario = request.getParameter("cUsuario");
    Date fIngreso = new Date(); //(request.getParameter("fIngreso"));
    
    AsInterfaceController ctrl = new AsInterfaceController();
    boolean existe = ctrl.crearDepartamento(cInterface, dInterface,cUsuario,fIngreso);  
    String mensaje;
    
  	if (existe) {
  		mensaje = "Se creo AsInterface";
  	} else {
  		response.sendRedirect("GuardarAsInterface.html");
  		mensaje = "Error al guardar el AsInterface";
  	}
    
    %>
    
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=mensaje %>
</body>
</html>