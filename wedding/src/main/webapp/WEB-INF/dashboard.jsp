<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
  rel="stylesheet" 
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
  crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome To Wedding Planner</h1>
<a href="/logout">Logout</a>

<hr>
<table class="table table-dark table-hover">
<thead>
	<tr>
		<th>Wedding</th>
		<th>Date</th>
		<th>Guests</th>
		<th>Action</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${weddings}" var="wedding">
<tr>
<td><a href="/weddings/${wedding.id}">${wedding.wedderOne } ${wedding.wedderTwo}</a></td>
<td><fmt:formatDate value="${wedding.date}" pattern="MMM dd, yyyy"/></td>
<td>${wedding.guests.size()}</td>
<c:choose>
<c:when test="${wedding.planner.id == user.id }">
<td><a href="/weddings/delete">Delete</a></td>
</c:when>
<c:when test="${wedding.guests.contains(user) }">
<td><a href="/weddings/unrsvp/${wedding.id}">Un-RSVP</a></td>
</c:when>
<c:otherwise>
<td><a href="/weddings/rsvp/${wedding.id}">RSVP</a></td>

</c:otherwise>

</c:choose>

</c:forEach>
</tr>
</tbody>

</table>

</div>
<a href="/weddings/new" class="btn btn-primary">Add Wedding</a>
</body>
</html>