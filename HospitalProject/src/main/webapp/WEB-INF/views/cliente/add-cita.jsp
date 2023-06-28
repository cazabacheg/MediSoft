<%@page import="java.util.List"%>
<%@page import="com.project.hospital.model.Especialidad"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cita : Registrar</title>
</head>
<body>

<%@include file="../template/menu.jsp"%>
<% 
if (!Utils.isLogged(sesion)) {
	response.sendRedirect("/");
}
List<Especialidad> especialidades = (List<Especialidad>)request.getAttribute("especialidades"); %>

<div class="container">
		<h1>Cita : Registrar</h1>
		<hr>

		<%@include file="../template/message-box.jsp"%>

		<div class="col-md-12">

			<form action="add-cita" method="post">
				<input class="form-control" type="number" name="id" hidden="true">
					<div class="form-group">
					<label for="fecha">Fecha <b class="text-danger">*</b></label> <input
						class="form-control" type="date" name="fecha" required>
				</div>
				<div class="form-group">
					<label for="hora">Hora <b class="text-danger">*</b></label>
					<input class="form-control" type="time" name="hora" required>
				</div>
				<div class="form-group">
					<label for="descripcion">Descripción <b class="text-danger">*</b></label>
					<textarea class="form-control" name="descripcion" rows="5" required></textarea>
				</div>
				<div class="form-group">
					<label for="especialidad.id">Especialidad <b class="text-danger">*</b></label>
					<select class="form-control" name="especialidad.id" required>
					<% for(Especialidad item: especialidades) {%>
					<option value="<%= item.getId() %>"><%= item %></option>
					<% } %>
					</select>
				</div>

				<div class="form-group">
					<input class="btn btn-primary" type="submit" name="action"
						value="Registrar">
						<a class="btn btn-danger" href="mis-citas">Cancelar</a>
				</div>
			</form>
		</div>

	</div>

</body>
</html>