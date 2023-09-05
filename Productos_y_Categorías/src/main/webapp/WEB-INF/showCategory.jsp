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
<title>Show Category</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container mx-auto">

		<h1>~<c:out value="${category.name}"></c:out>~</h1>
		<a href="../" class="float-end">Back home</a>
		<div class="row mt-4">
			<div class="col-6 mt-4">
				<h4>Products:</h4>
				<ul>
					<c:forEach items="${category.getProducts()}" var="p">
						<li>
							<c:out value="${p.name}"></c:out>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-6 mt-4">
				<h4>Add Product:</h4>
				<form:form action="/catprod/${category.id}" method="post" modelAttribute="catprod">
					<form:input type="hidden" path="category" value="${category.id}"/>
					<form:select class="form-control" path="product">
						<c:forEach items="${products}" var="p">
							<form:option value="${p.id}"> ${p.name} </form:option>
						</c:forEach>
					</form:select>
					<button>Add</button>
				</form:form>
			</div>
			<div class="col-6">	
			</div>
			<div class="col-6 mt-4">
				<h2>Delete Product:</h2>
				<form:form action="/catprod/${category.id}/del" method="post" modelAttribute="catprod">
					<form:input type="hidden" path="category" value="${category.id}"/>
					<form:select class="form-control" path="product">
						<c:forEach items="${category.getProducts()}" var="c">
							<form:option value="${c.id}"> ${c.name} </form:option>
						</c:forEach>
					</form:select>
					<button>Delete</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>