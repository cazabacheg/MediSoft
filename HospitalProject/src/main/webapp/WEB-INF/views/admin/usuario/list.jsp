<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.project.hospital.utils.Utils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
</head>
<body>

	<%@include file="../../template/menu.jsp"%>

	<%
	List<Usuario> data = (List<Usuario>) request.getAttribute("usuarios");

	if (!Utils.isAdmin(user)) {
		response.sendRedirect("/");
	}
	%>

	<div class="container">
		<h1>Usuarios</h1>
		<hr>

		<div class="text-right mb-2">
			<a class="btn btn-success" href="add-usuario">Registrar Nuevo</a>
		</div>

		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>Nombres</th>
						<th>Apellidos</th>
						<th>Username</th>
						<th>Rol</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
					if (data != null) {
						for (Usuario item : data) {
					%>
					<tr>
						<td><%=item.getNombres()%></td>
						<td><%=item.getApellidos()%></td>
						<td><%=item.getUsername()%></td>
						<td><%=item.getRol()%></td>
						<td class="text-right">
							<div class="dropdown">
								<button class="btn btn-primary dropdown-toggle" type="button"
									id="dropdownMenuButton" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">Opciones</button>
								<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
									<a class="dropdown-item"
										href="edit-usuario?id=<%=item.getId()%>">Editar</a>
									<form action="delete-usuario">
										<input type="number" name="id" value="<%=item.getId()%>"
											required hidden="true"> <input class="dropdown-item"
											type="submit" value="Eliminar">
									</form>
								</div>
							</div>
						</td>
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