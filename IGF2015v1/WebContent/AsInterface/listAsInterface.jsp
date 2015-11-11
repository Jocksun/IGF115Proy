<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.*" %>
<%@page import="org.springframework.context.* , org.springframework.context.support.*, org.springframework.web.context.support.*" %>
<%@page import="sv.edu.ues.igf115.controller.*"%>
<%@page import="sv.edu.ues.igf115.model.*"%>

<%
ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
CtrlAsInterface ctrlAsInter=(CtrlAsInterface) context.getBean("ctrlAsInter");

List<AsInterface> list= ctrlAsInter.daAsInterfaces();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Users</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Código</th>
                <th>Descripción</th>
                <th>Usuario</th>
                <th>Fecha</th>
                <th colspan=2>ACCIÓN</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="<%=list%>" var="AsInterface">
                <tr>
                    <td><c:out value="${AsInterface.c_interface}" /></td>
                    <td><c:out value="${AsInterface.d_interface}" /></td>
                    <td><c:out value="${AsInterface.c_usuario}" /></td>
                    <td><c:out value="${AsInterface.fIngreso}" /></td>
                    
                    <td><a href="editAsInterface.jsp?userId=<c:out value="${AsInterface.c_interface}"/>">Modificar</a></td>      
                    <td><a href="deleteAsInterface.jsp?userId=<c:out value="${AsInterface.c_interface}"/>">Eliminar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="nuevoAsInterface.jsp">Crear Nuevo</a></p>
</body>
</html>