<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<%@include file="template/menu.jsp"%>

	<%
	String adminDefault = (String) request.getAttribute("adminDefault");
	%>

	<div>
		<%
		if (adminDefault != null) {
		%>
		<div class="alert alert-success alert-dismissable">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>¡Éxito!</strong>
			<%=adminDefault%>
		</div>
		<%
		}
		%>
	</div>

</body>
</html>