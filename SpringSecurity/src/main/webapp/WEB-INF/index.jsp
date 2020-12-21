<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1>Welcome To Users</h1>
<c:if test="${logoutMessage != null}">
        <c:out value="${logoutMessage}"></c:out>
    </c:if>
  <div class="row">
    <div class="col">
      <h4>Register</h4>
		<p><form:errors path="user.*"/></p>
			<form:form action="/registration" method="post" modelAttribute="user">
			    <div class="form-group">
			        <form:label path="username">UserName</form:label>
			        <form:errors path="username"/>
			        <form:input class="form-control" path="username"/>
			    </div>
			    <div class="form-group">
			        <form:label path="fullName">Full Name</form:label>
			        <form:errors path="fullName"/>
			        <form:input class="form-control" path="fullName"/>
			    </div>
			    <div class="form-group">
			        <form:label path="email">Email</form:label>
			        <form:errors path="email"/>
			       <form:input type="email" class="form-control" path="email"/>
			    </div>
			    <div class="form-group">
			        <form:label path="password">Password</form:label>
			        <form:errors path="password"/>
			       <form:input type="password" class="form-control" path="password"/>
			    </div>
			    <div class="form-group">
			        <form:label path="passwordConfirmation">Confirm Password</form:label>
			        <form:errors path="passwordConfirmation"/>
			       <form:input type="password" class="form-control" path="passwordConfirmation"/>
			    </div>
			    <input class="btn btn-dark" type="submit" value="Submit"/>
			</form:form>
    </div>
        <div class="col">
      <h4>Login</h4>
          <c:if test="${errorMessage != null}">
        <c:out value="${errorMessage}"></c:out>
    </c:if>
      <form method="POST" action="/login">
      <div class="form-group">
      <label>User Name:</label>
	      <input type="text" class="form-control" name="username">
	      
	  </div>
	  <div class="form-group">
	  <label>Password:</label>
	      <input type="text" class="form-control" name="password">
      </div>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <button class="btn btn-light">Login</button>
      </form>
    </div>
  </div>
  </div>
</body>
</html>