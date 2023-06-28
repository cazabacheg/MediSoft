<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<%@include file="../template/menu.jsp"%>

	<div class="container">

		<h3>Register</h3>
		<hr>

		<%@include file="../template/message-box.jsp"%>

		<div class="col-md-6">

			<form action="register" method="post">
				<input class="form-control" type="number" name="id"
					value="${ user.id }" hidden="true">
				<div class="form-group">
					<label for="username">Username <b class="text-danger">*</b></label>
					<input class="form-control" type="text" name="username"
						value="${ user.username }" required>
				</div>
				<div class="form-group">
					<label for="password">Password <b class="text-danger">*</b></label>
					<input class="form-control" type="password" name="password"
						value="${ user.password }" required>
				</div>
				<div class="form-group">
					<label for="nombres">Nombres <b class="text-danger">*</b></label> <input
						class="form-control" type="text" name="nombres"
						value="${ user.nombres }" required>
				</div>
				<div class="form-group">
					<label for="apellidos">Apellidos <b class="text-danger">*</b></label>
					<input class="form-control" type="text" name="apellidos"
						value="${ user.apellidos }" required>
				</div>
				<div class="form-group">
					<input class="btn btn-primary" type="submit" name="action"
						value="Registrar">
				</div>
			</form>
		</div>

	</div>
</body>
</html>