<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	

<title>Connect in.Com</title>
<style>




</style>
</head>
<body>

 Welcome to Connect in.com....!!!!!!
 
 
	
	   <div style="float: right; position: absolute; top: 0px; right: 90px;"><a href="login"><span class="glyphicon glyphicon-log-in"></span>Login</a><br></div>
	   <div style="float: right; position: absolute; top: 0px; right: 20px;"><a href="signup"><span class="glyphicon glyphicon-user"></span>Register</a></div>
	
    
   	   <div style="float: right; position: absolute; top: 75px; right:135px;"><a href="login"><span class="glyphicon glyphicon-user"></span>Welcome ${Welcome.firstname} ${Welcome.lastname}!!</a><br></div>
	   <div style="float: right; position: absolute; top: 75px; right:70px;"><a href="home"><span class="glyphicon glyphicon-log-in"></span>Logout</a><br></div> 
	   <div style="float: right; position: absolute; top: 0px; right:220px;"><a href="viewfriend"><span class="glyphicon glyphicon-user"></span>Friends</a></div>
	
	
	
</body>
</html>