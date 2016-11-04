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
    	background-color: #cccccc;
    	 position: absolute;
         bottom: 10%;
         right: 15%;
         width: 400px;
         height: 80px;
         text-align:center;
         
    		/* width:40%;
    		background-color: #cccccc;
    		text-align:center;
    		Bottom:5px;
    		position:fixed; */
    	}
    	.chatUsers{
    	     position: absolute;
    	     background-color: #ccfffc;
             bottom:10%;
             right: 1%;
             width: 15%;
             z-index: 8;
    		/* width:15%;
    		background-color: #ccfffc;
    		Bottom:5px;
    	    position:absolute;
    	    alignment:right; */
    	}
    	/* .message_input{
    	     width:40px;
    	} */
    	.message_input_wrapper{
    	width: 250px;
	    height: 30px; 
	   font-family: 'Exo', sans-serif;
	   font-size: 16px;
	   font-weight: 400;
	   
    	}
    	

    .header div span{
	       color: #555555 !important;
	       float: left;
	       color: #fff;
	       font-family: 'Exo', sans-serif;
	       font-size: 35px;
	       font-weight: 200;
       }
    </style>
<title>peers</title>
</head>
<body>
    <div class="header">
			<div><span> Chat Here...!</span></div>
		</div>
	<div class='chatWindow'>
	<!-- <div class="top_menu">
        <div class="buttons">
            <div class="button close"></div>
            <div class="button minimize"></div>
            <div class="button maximize"></div>
        </div>
	<div class="title">Chat</div>
    </div> -->
      <form:form action="storechat" method="post">
		
    <c:forEach var="m" items="${msgs}">
    <p>${m.getMessage()}</p>
    <%-- ${m.getMessage()} ${m.getFromUser()} ${m.getToUser()}  --%>
    <c:if test="${m.fromUser=chat.uid}">
  
      <div class="msgs">
        <p>${m.getMessage()}</p>
       
      </div>
    
    </c:if>
    <c:if test="${m.toUser==chat.uid}">
    
   
      <div class="msgs">
        <p>${m.getMessage()}</p>
       
      </div>
    
    </c:if>
    </c:forEach>
    
        <div class="message_input_wrapper">
        
              
        
               <form:input type="text" path="message" placeholder="Type your message here..." />
          
           <form:input type="hidden" path="fromUser"  placeholder="Type your message here..." />
      
           <button type="submit"class="btn btn-info">Send</button>
      
        </div>         
        
    </form:form>
	</div>
	<div class='chatUsers'>
	  <ul>
	  
		 <c:forEach var="c" items="${chatusers}">
			<li><a href="startChat?frdid=${c.friend.user.uid}">${c.friend.userFriend.username}</a></li>
		</c:forEach>
	  </ul>
	</div>
</body>
</html>
