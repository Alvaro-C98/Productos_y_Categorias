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
<title>Show Product</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container mx-auto">

		<h1>~<c:out value="${product.name}"></c:out>~</h1>
		<a href="../" class="float-end">Back home</a>
		<div class="row mt-4">
			<div class="col-6 mt-4">
				<h4>Categories</h4>
				<ul>
					<c:forEach items="${product.getCategories()}" var="c">
						<li>
							<c:out value="${c.name}"></c:out>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-6 mt-4">
				<h4>Add Category:</h4>
				<form:form action="/prodcat/${product.id}" method="post" modelAttribute="prodcat">
					<form:input type="hidden" path="product" value="${product.id}"/>
					<form:select class="form-control" path="category">
						<c:forEach items="${categories}" var="c">
							<form:option value="${c.id}"> ${c.name} </form:option>
						</c:forEach>
					</form:select>
					<button>Add</button>
				</form:form>
			</div>
			<div class="col-6">	
			</div>
			<div class="col-6 mt-4">
				<h4>Delete Category:</h4>
				<form:form action="/prodcat/${product.id}/del" method="post" modelAttribute="prodcat">
					<form:input type="hidden" path="product" value="${product.id}"/>
					<form:select class="form-control" path="category">
						<c:forEach items="${product.getCategories()}" var="c">
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