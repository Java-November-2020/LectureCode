<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

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
<h1>${wedding.wedderOne } ${wedding.wedderTwo}</h1>
<a href="/weddings">Dashboard</a>
<a href="/logout">Logout</a>
<hr>
<p>Date: ${wedding.date}</p>
<p>Address: ${wedding.address}</p>
<h3>Guests</h3>
<c:if test="${wedding.guests.size() < 1 }"><p>Nobody Has RSVP's yet</p></c:if>
<ul>
<c:forEach items="${wedding.guests}" var="guest">>
<li>${guest.firstName} ${guest.lastName}</li>
</c:forEach>
</ul>

</div>
</body>
</html>