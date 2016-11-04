<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>   
    
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

 body {
    background: url(.//resources/images/home.jpg) no-repeat fixed center center; 

}


</style>
</head>
<body>
<body background="resources/images/home.jpg">
 <c:if test="${login==true}">
		<%@include file="login.jsp" %>
	</c:if>
	<c:if test="${signup==true}">
		<%@include file="signup.jsp" %>
	</c:if> 
	
		<c:if test="${empty Welcome}">
	
	   <div style="float: right; position: absolute; top: 0px; right: 90px;"><a href="login"><span class="glyphicon glyphicon-log-in"></span>Login</a><br></div>
	   <div style="float: right; position: absolute; top: 0px; right: 20px;"><a href="signup"><span class="glyphicon glyphicon-user"></span>Register</a></div>
	</c:if>
	
	
    <c:if test="${not empty Welcome}">
    	<div style="float: right; position: absolute; top: 75px; right:135px;"><a href="login"><span class="glyphicon glyphicon-user"></span>Welcome ${Welcome.firstname} ${Welcome.lastname}!!</a><br></div>
    	<div style="float: right; position: absolute; top: 20px; right:500px;"><a href="viewfriend"><span class="glyphicon glyphicon-user"></span>friends list</a><br></div>
    	<div style="float: right; position: absolute; top: 20px; right:700px;"><a href="viewblog"><span class="glyphicon glyphicon-user"></span>blog</a><br></div>
    	<div style="float: right; position: absolute; top: 20px; right:800px;"><a href="Viewevent"><span class="glyphicon glyphicon-user"></span>event</a><br></div>
    	<div style="float: right; position: absolute; top: 20px; right:600px;"><a href="viewchat"><span class="glyphicon glyphicon-user"></span>chat</a><br></div>
	    <div style="float: right; position: absolute; top: 75px; right:70px;"><a href="home"><span class="glyphicon glyphicon-log-out"></span>Logout</a><br></div>
	</c:if>
</body>
</html>