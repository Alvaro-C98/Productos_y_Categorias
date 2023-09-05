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
<title>New Product</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container">
		<h2>New Product</h2>
		<form:form action="/products/new" method="POST" modelAttribute="product">
			<div class="form-group">
				<form:label path="name" class="form-label">Name: </form:label>
				<form:input path="name" class="form-control"/>
				<form:errors path="name" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="description" class="form-label">Description: </form:label>
				<form:input path="description" class="form-control" type="text"/>
				<form:errors path="description" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="price" class="form-label">Price: </form:label>
				<form:input path="price" class="form-control" type="number"/>
				<form:errors path="price" class="text-danger"/>
			</div>
			<button class="btn btn-success mt-2">Created</button>
		</form:form>
		<a href="../" class="float-end">Back home</a>
	</div>
</body>
</html>