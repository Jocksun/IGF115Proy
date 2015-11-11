<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="sv.edu.ues.igf115.controller.*"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.*" %>
<%@page import="org.springframework.context.* , org.springframework.context.support.*, org.springframework.web.context.support.*" %>
<%@page import="sv.edu.ues.igf115.model.*" %>

<%
ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
TbAplicativoController ctrlDept=(TbAplicativoController) context.getBean("ctrlApli");
List<TbAplicativo> list= ctrlDept.daDepartamentos();
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Aplicativos</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Codigo Aplicativo</th>
                <th>Descripcion</th>
                <th>fecha Ingreso</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="<%=list%>" var="user">
                <tr>
                    <td><c:out value="${user.c_aplicativo}" /></td>
                    <td><c:out value="${user.d_aplicativo}" /></td>
                    <td><c:out value="${user.f_ingreso}" /></td>  
                    <td><a href="edit.jsp?userId=<c:out value="${user.c_aplicativo}"/>">Update</a></td>
                    <td><a href="delete.jsp?userId=<c:out value="${user.c_aplicativo}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="new.jsp">Add User</a></p>
</body>
</html>