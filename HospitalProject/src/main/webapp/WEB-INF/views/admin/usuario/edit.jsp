<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario : Editar</title>
</head>
<body>

	<%@include file="../../template/menu.jsp"%>

	<%
	if (!Utils.isAdmin(user)) {
		response.sendRedirect("/");
	}

	Usuario usuario = (Usuario) request.getAttribute("usuario");
	%>

	<div class="container">
		<h1>Usuario : Editar</h1>
		<hr>

		<%@include file="../../template/message-box.jsp"%>

		<div class="col-md-12">

			<form action="edit-usuario" method="post">
				<input class="form-control" type="number" name="id"
					value="${usuario.id}" hidden="true">
				<div class="form-group">
					<label for="nombres">Nombres <b class="text-danger">*</b></label> <input
						class="form-control" type="text" name="nombres"
						value="${usuario.nombres}" required>
				</div>
				<div class="form-group">
					<label for="apellidos">Apellidos <b class="text-danger">*</b></label>
					<input class="form-control" type="text" name="apellidos"
						value="${usuario.apellidos}" required>
				</div>
				<div class="form-group">
					<label for="username">Username <b class="text-danger">*</b></label>
					<input class="form-control" type="text" name="username"
						value="${usuario.username}" required>
				</div>
				<div class="form-group">
					<label for="password">Password <b class="text-danger">*</b></label>
					<input class="form-control" type="password" name="password"
						value="${usuario.password}" required>
				</div>
				<div class="form-group">
					<label for="rol">Rol <b class="text-danger">*</b></label> <select
						class="form-control" name="rol" required>
						<option value="Admin"
							<%=usuario.getRol().equals("Admin") ? "selected" : ""%>>Administrador</option>
						<option value="Usuario"
							<%=usuario.getRol().equals("Usuario") ? "selected" : ""%>>Usuario</option>
					</select>
				</div>

				<div class="form-group">
					<input class="btn btn-primary" type="submit" name="action"
						value="Actualizar"> <a class="btn btn-danger"
						href="usuarios">Cancelar</a>
				</div>
			</form>
		</div>

	</div>

</body>
</html>