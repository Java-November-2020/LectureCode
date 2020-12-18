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
  <div class="row">
    <div class="col">
      <h4>Login</h4>
      <p>${loginError}</p>
      <form method="POST" action="/login">
      <div class="form-group">
      <label name="Email Address">Email Address:</label>
	      <input type="text" class="form-control" name="lemail">
	      
	  </div>
	  <div class="form-group">
	  <label name="Password">Password:</label>
	      <input type="text" class="form-control" name="lpassword">
      </div>
      <button class="btn btn-light">Login</button>
      </form>
    </div>
    <div class="col">
      <h4>Register</h4>

			<form:form action="/register" method="post" modelAttribute="user">
			    <div class="form-group">
			        <form:label path="firstName">First Name</form:label>
			        <form:errors path="firstName"/>
			        <form:input class="form-control" path="firstName"/>
			    </div>
			    <div class="form-group">
			        <form:label path="lastName">Last Name</form:label>
			        <form:errors path="lastName"/>
			        <form:input class="form-control" path="lastName"/>
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
			        <form:label path="confirmPassword">Confirm Password</form:label>
			        <form:errors path="confirmPassword"/>
			       <form:input type="password" class="form-control" path="confirmPassword"/>
			    </div>
			    <input class="btn btn-dark" type="submit" value="Submit"/>
			</form:form>
    </div>
  </div>
</body>
</html>