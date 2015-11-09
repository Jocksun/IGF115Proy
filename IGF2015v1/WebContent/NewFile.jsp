<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="sv.edu.ues.igf115.controller.*" %>
<%@ page import="sv.edu.ues.igf115.dao.*" %>
<%@ page import="sv.edu.ues.igf115.model.*" %>
<%@ page import="sv.edu.ues.igf115.utilidades.Conversiones" %>
<%@ page import="java.util.Date" %>
<%

//     TbTipoAtributo tipoAtributo = new TbTipoAtributo();
// 	String disable="";
//     TbTipoAtributoController tb = new TbTipoAtributoController();

// 	String accion = request.getParameter("accion");
// 	if (accion == null) accion = "";
	
// 	Integer ident = 0;
// 	if (request.getParameter("idconcepto") == null) ident = 0;
// 	else ident = Integer.parseInt(request.getParameter("idconcepto"));
	
// 	if (ident == 0) {
// 		tipoAtributo = new TbTipoAtributo();
// 	} else {
// 		tipoAtributo = tb.findById(ident);
// 	}
	
// 	if (accion.equals("guardar")){
// 		Conversiones c = new Conversiones();
// 		concepto.setUser(c.getUsuario());
// 		concepto.setDatareg(new Date());
// 		concepto.setDescripcion(request.getParameter("descripcion"));
// 		if (ident != 0) concepto.setIdconcepto(ident);
// 		ctrl.guardar(concepto);
// 		response.sendRedirect("Lista.jsp");
// 	}else if (accion.equals("borrar")) {
// 		concepto = ctrl.findById(ident);
// 		ctrl.borrar(ident);
// 		response.sendRedirect("Lista.jsp");
// 	} else if (accion.equals("ver")) {
// 		disable = "disabled";
// 	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="../style.css" media="screen,projection" />
	<title>UES-IGF115-Clave1-Grupo9-2014</title>
</head>
<body>
<div id="wrap">
	<div id="header">
		<p class="hide">
			skip to: <a href="#">content</a> | <a href="#">navigation</a><br />
		</p>
		<h1><a href="#">IGF115-Clave1-Grupo9</a></h1>
		<p id="slogan">UES-2014</p>
	</div><div class="inner_copy"></div>
	<div id="sitemenu">
		<h2 class="hide">Sample menu:</h2>
		<ul>
			<li><a class="current" href="#" onclick="javascript:anchodiv();">Inicio</a></li>
			<li>
				<a href="#">Catalogos</a>
				<ul>
					<li><a href="/Clave1Grupo9/Cliente/listaTipoCliente.jsp">Tipo de Cliente</a></li>
					<li><a href="/Clave1Grupo9/Establecimiento/CreaEst.html">Establecimiento</a></li>
					<li><a href="/Clave1Grupo9/Pais/Creapais.html">Pais</a></li>
					<li><a href="/Clave1Grupo9/Concepto/Lista.jsp">Concepto</a></li>
				</ul>
			</li>
			<li>
				<a href="#">Maestros</a>
				<ul>
					<li><a href="/Clave1Grupo9/Cliente/listaCliente.jsp">Cliente</a></li>
					<li><a href="/Clave1Grupo9/TarjetaCredito/creartarjeta.html">Tarjeta de Credito</a></li>
					<li><a href="/Clave1Grupo9/TarjetaCredito/consultartarjeta.html">consultar</a></li>
					<li><a href="/Clave1Grupo9/TarjetaCredito/eliminartarjeta.html">eliminar</a></li>
					<li><a href="/Clave1Grupo9/TarjetaCredito/modificatargeta.html">modificar</a></li>
				</ul>
			</li>
			<li>
				<a href="#">Procesos</a>
				<ul>
					<li><a href="#">Tarjeta-Cliente</a></li>
					<li><a href="/Clave1Grupo9/Transaccion/Lista.jsp">Transaccion</a></li>
					<li><a href="#">Estado de Cuenta</a></li>
				</ul>
			</li>
			<li>
				<a href="#">Administracion</a>
				<ul>
					<li><a href="/Clave1Grupo9/Administracion/Usuarios/Lista.jsp">Usuarios</a></li>
				</ul>
			</li>
			<li><a href="j_spring_security_logout">Cerrar sesión</a></li>
		</ul>
	</div>
	<div id="extras">
	</div>
	<div id="content">
		<form action="Edit.jsp" method="post">
			<input type="hidden" name="accion" value="guardar"  />
			<input type="hidden" name="idconcepto" value=""  />
			<table>
				<thead>
					<caption>Concepto</caption>
				</thead>
				<tbody>
					<tr>
						<td>C&oacute;digo</td>
						<td><input type="text" value=""  /></td>
					</tr>
					<tr>
						<td>Descripci&oacute;n</td>
						<td><input type="text" name="descripcion" value="" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="Guardar" />
							<input type="reset" value="Limpiar" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div id="footer">
		<div class="fcenter">
			<div class="fleft"><p>IGF115</p></div>
			<div class="fright"><p>Clave 1</p></div>
			<div class="fcenter"><p>Grupo 9</p></div>
		</div>
	</div>
</div>
</body>
</html>