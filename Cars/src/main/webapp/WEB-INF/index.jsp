<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Cars dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1>Welcome to Cars dot Com</h1>
<hr>
<a href="/add" class="btn btn-primary">Add New Car</a><a href="/accessory/new" class="btn btn-primary">Add New Accessory</a>
<hr>
<h3>Showing All Cars</h3>
<table class="table table-dark">
<thead>
<tr>
<th>id</th>
<th>Make</th>
<th>Model</th>
<th>Color</th>
<th>Years</th>
<th>Transmission</th>
<th>Registered</th>
</tr>
</thead>
<tbody>

<c:forEach items="${allCars}" var="car">
<tr>
	<td>${car.id}</td>
	<td>${car.make}</td>
	<td><a href="${car.id}">${car.model}</a></td>
	<td>${car.color}</td>
	<td>${car.year}</td>
	<td>${car.transmission}</td>
	<td>
	<c:choose>
	<c:when test="${car.title != null}">
	Yes
	</c:when>
	<c:otherwise>
	No
	</c:otherwise>
	</c:choose>
	</td>
</tr>
</c:forEach>


</tbody>

</table>



</div>
</body>
</html>