<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1>Details for ${car.model}</h1>
<hr>
<p>Make: ${car.make}</p>
<p>Year: ${car.year}</p>
<p>Color: ${car.color}</p>
<p>Transmission: ${car.transmission}</p>
<hr>
<h2>After Market Accessories</h2>
<ol>
<c:forEach items="${car.accessories}" var="acc">
<li>Name: ${acc.name}</li>
<ul>
<li>Description: ${acc.description}</li>
<li>Price: ${acc.price }</li>
</ul>
</c:forEach>
</ol>
<hr>
<h2>Register This Car</h2>
<c:choose>
<c:when test="${car.title != null}">
<p>Vin Number: ${car.title.vin}</p>
<p>Registered City: ${car.title.city}</p>
<p>Registered State: ${car.title.state}</p>
</c:when>
<c:otherwise>
<h2>Register The Car!</h2>
<form:form method="POST" action="/addTitle" modelAttribute="title">
	<div class="form-group">
		<form:label path="vin">Vin Number
		<form:errors path="vin"/>
		<form:input path="vin"/></form:label>
	</div>
		<div class="form-group">
		<form:label path="city">City
		<form:errors path="city"/>
		<form:input path="city"/></form:label>
	</div>
		<div class="form-group"> State
		<form:label path="state">
		<form:errors path="state"/>
		<form:input path="state"/></form:label>
	</div>
	<form:input type="hidden" value="${car.id}" path="car"/>

<button class="btn btn-primary">Register This Vehicle!</button>
</form:form>
</c:otherwise>
</c:choose>
<hr>
<h3>Edit Car</h3>
<form:form method="POST" action="/edit/${car.id}" modelAttribute="car">
<div class="form-group">
	<form:label path="make">Make:
	<form:errors path="make"/>
	<form:input path="make"/></form:label>
</div>
<div class="form-group">
	<form:label path="model">Model:
	<form:errors path="model"/>
	<form:input path="model"/></form:label>
</div>
<div class="form-group">
	<form:label path="color">Color:
	<form:errors path="color"/>
	<form:input path="color"/></form:label>
</div>
<div class="form-group">
	<form:label path="year">Year:
	<form:errors path="year"/>
	<form:input path="year"/></form:label>
</div>
<div class="form-group">
	<form:label path="transmission">Transmission:
	<form:errors path="transmission"/>
	<form:input path="transmission"/></form:label>
</div>
<button class="btn btn-dark">Save Changes</button>

</form:form>


<a href="/delete/${car.id}" class="btn btn-danger">Delete This Car</a>
</div>
</body>
</html>