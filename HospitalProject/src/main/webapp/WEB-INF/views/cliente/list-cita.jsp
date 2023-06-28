<%@page import="java.util.List"%>
<%@page import="com.project.hospital.dto.CitaDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis Citas</title>
</head>
<body>
	<%@include file="../template/menu.jsp"%>
	<%
	if (!Utils.isLogged(sesion)) {
		response.sendRedirect("/");
	}

	List<CitaDto> data = (List<CitaDto>) request.getAttribute("citas");
	%>

	<div class="container">
		<h1>Mis Citas</h1>
		<hr>

		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>Fecha</th>
						<th>Hora</th>
						<th>Especialidad</th>
						<th>Descripción</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (data != null) {
						for (CitaDto item : data) {
					%>
					<tr>
						<td><%=item.getFecha()%></td>
						<td><%=item.getHora()%></td>
						<td><%=item.getEspecialidad()%></td>
						<td><%=item.getDescripcion()%></td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>