<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container">
		<h2>New Category</h2>
		<form:form action="/categories/new" method="POST" modelAttribute="category">
			<div class="form-group">
				<form:label path="name" class="form-label">Name: </form:label>
				<form:input path="name" class="form-control"/>
				<form:errors path="name" class="text-danger"/>
			<button class="btn btn-success mt-2">Created</button>
		</form:form>
		<a href="../" class="float-end">Back home</a>
	</div>
</body>
</html>