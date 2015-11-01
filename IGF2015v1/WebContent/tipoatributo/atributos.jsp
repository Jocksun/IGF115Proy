<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="sv.edu.ues.igf115.controller.*"%>
<%@page import="sv.edu.ues.igf115.model.*"%>
<%@page import="java.util.*"%>


<%
				// retrieve your list from the request, with casting 
				ArrayList<TbTipoAtributo> list = (ArrayList<TbTipoAtributo>) request.getAttribute("lst");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
<title>Test page</title>
 
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href="bootstrap.css" rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tipo Atributo</title>
</head>
<body>
<div class="wrap" >
<section>
            <div class="container">
	   <table class="table table-hover">

		<thead>
			<tr>
				<th>ID Atributo</th>
				<th>Tipo Atributo</th>
				<th>Fecha</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
				// print the information about every category of the list
				for (TbTipoAtributo category : list) {%>
				    <tr>
					<td><%=category.getCTipoAtributo()%></td>
					<td><%=category.getDTipoAtributo()%></td>
					<td><%=category.getFIngreso()%></td>
					 <td><a href="TbTipoAtributoController?action=edit&userId=<c:out value="<%=category.getCTipoAtributo()%>"/>">Update</a></td>
                    <td><a href="TbTipoAtributoController?action=delete&userId=<c:out value="<%=category.getCTipoAtributo()%>"/>">Delete</a></td>
                    <tr>
			<%	}
			%>
			

		</tbody>
	</table>
<!-- <p><a href="TbTipoAtributoController?action=insert">Add User</a> -->

<!-- </p>  -->
 <a href="../TbTipoAtributoController?action=insert" role="button" class="btn btn-info btn-lg" data-toggle="modal">Add new person</a>	
</div>
	</section>
</div>

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>