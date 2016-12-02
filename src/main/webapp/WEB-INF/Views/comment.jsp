<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Register</title>
<style type="text/css">

</style> 
<body>
<form:form action="store5" method="post">	 
 <c:forEach var="e" items="${errors}">
		<li>${e.getDefaultMessage()}" </li>
	</c:forEach> 
	<method="post">
	<textarea name="comments" id="comments" style="width:96%;height:150px;padding:2%;font-size:1.2em;color:white;background:url('/pix/samples/15l.jpg');background-position:center center;background-repeat:no-repeat;background-size:cover;">
Enter your comments here...

...and watch your comment box grow scrollbars!
</textarea>
<input type="submit" value="Submit">

    <%--  <div class="container">
      <div class="profile">
     <button class="profile__siri" id="toggleProfile">
            comment
      </button>
      <div class="profile__form">
        <div class="profile__fields">
           <div class="field">
           <label for="fieldUser" class="label" ></label>
        <form:input path='cdesc' name="fieldUser" placeholder="cdesc"  class="input" required="true" />
   </div> 
       <div class="profile__footer">
      <button type="submit" class="btn btn-success btn-sm">ADDcomment</button>
     --%>   
       <!--  <button class="btn">Login</button> -->
       </div>
     </div>
     </div>
    </div>
</form:form>
<script>
</script>
</body>
</html>