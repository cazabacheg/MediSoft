<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%@include file="../template/menu.jsp"%>

	<div class="container">

		<h3>Login</h3>
		<hr>

		<%@include file="../template/message-box.jsp"%>

		<div class="col-md-6">

			<form action="login" method="post">
				<div class="form-group">
					<label for="username">Username <b class="text-danger">*</b></label>
					<input class="form-control" type="text" name="username"  required>
				</div>
				<div class="form-group">
					<label for="password">Password <b class="text-danger">*</b></label>
					<input class="form-control" type="password" name="password" required>
				</div>
				<div class="form-group">
					<input class="btn btn-primary" type="submit" name="action"
						value="Login">
				</div>
			</form>
		</div>

	</div>
</body>
</html>