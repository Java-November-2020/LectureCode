<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First Spring Project</title>
</head>
<body>
	<h1>Hello from the VIEW!</h1>
	<h3>How are you feeling?</h3>
	<form action="/message">
		<input type="text" name="mood"/>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>