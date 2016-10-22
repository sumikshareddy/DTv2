<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
 
  <script>document.write('<base href="' + document.location + '" />');</script>
    <script data-require="angular.js@1.0.x" src="http://code.angularjs.org/1.0.7/angular.min.js" data-semver="1.0.7"></script>
    <style>
    	.chatWindow{
    		width:80%;
    		background-color: #cccccc;
    		text-align:center;
    		position:relative;
    	}
    	.chatUsers{
    		width:15%;
    		background-color: #ccfffc;
    		float:right;
    	}
    	.message_input{
    	     width:35%;
    	}
    </style>
<title>chats</title>
</head>
<body>
	<div class='chatWindow'>
	<div class="top_menu">
        <!-- <div class="buttons">
            <div class="button close"></div>
            <div class="button minimize"></div>
            <div class="button maximize"></div>
        </div> -->
	<div class="title">Chat</div>
    </div>
		<ul class="messages"></ul>
    <div class="bottom_wrapper clearfix">
    Your Chatting with ${friend.username}
        <div class="message_input_wrapper">
            <input class="message_input" placeholder="Type your message here..." />
            <input type="hidden" >
        </div>
        <div class="send_message">
            <div class="icon"></div>
            <div class="btn btn-info">Send</div>
        </div>
    </div>
	</div>
	<div class='chatUsers'>
	<ui>
		<c:forEach var="c" items="${chatusers}">
			<li><a href="startChat?userFriend=${c.uid}">${c.username}</a></li>
		</c:forEach>
	</ui>
	</div>
</body>
</html>
