<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Especialidad : Editar</title>
</head>
<body>

	<%@include file="../../template/menu.jsp"%>
	
	<%
	if (!Utils.isAdmin(user)) {
		response.sendRedirect("/");
	}
	%>

	<div class="container">
		<h1>Especialidad : Editar</h1>
		<hr>

		<%@include file="../../template/message-box.jsp"%>

		<div class="col-md-12">

			<form action="edit-especialidad" method="post">
				<input class="form-control" type="number" name="id"
					value="${ especialidad.id }" hidden="true">
				<div class="form-group">
					<label for="nombre">Nombre <b class="text-danger">*</b></label> <input
						class="form-control" type="text" name="nombre"
						value="${ especialidad.nombre }" required>
				</div>
				<div class="form-group">
					<label for="precio">Precio <b class="text-danger">*</b></label> <input
						class="form-control" type="number" name="precio" min="0" step="0.01"
						value="${ especialidad.precio }" required>
				</div>

				<div class="form-group">
					<input class="btn btn-primary" type="submit" name="action"
						value="Actualizar">
						<a class="btn btn-danger" href="especialidades">Cancelar</a>
				</div>
			</form>
		</div>

	</div>

</body>
</html>