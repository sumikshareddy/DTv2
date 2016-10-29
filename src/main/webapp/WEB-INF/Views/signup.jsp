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

<style>
 body {
    background: url(.//resources/images/rose_wine_fire.jpg) no-repeat fixed center center; 
    background-size: cover;
     font-family: Montserrat; 
} 

  .register {
    width: 213px;
    height: 36px;
   /*  background: url('http://i.imgur.com/fd8Lcso.png') no-repeat; */
    margin: 30px auto;
} 

.register-block {
    width: 320px;
    padding: 20px;
    background: #fff;
    border-radius: 5px;
    border-top: 5px solid #ff656c;
    margin: 0 auto;
}

.register-block h1 {
    text-align: center;
    color: #000;
    font-size: 18px;
    text-transform: uppercase;
    margin-top: 0;
    margin-bottom: 20px;
}

.register-block input {
    width: 100%;
    height: 42px;
    box-sizing: border-box;
    border-radius: 5px;
    border: 1px solid #ccc;
    margin-bottom: 20px;
    font-size: 14px;
    font-family: Montserrat;
    padding: 0 20px 0 50px;
    outline: none;
}

.register-block input#username {
    background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px top no-repeat;
    background-size: 16px 80px;
}

.register-block input#username:focus {
    background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px bottom no-repeat;
    background-size: 16px 80px;
}

.register-block input#password {
    background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px top no-repeat;
    background-size: 16px 80px;
}

.register-block input#password:focus {
    background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px bottom no-repeat;
    background-size: 16px 80px;
}

.register-block input:active, .login-block input:focus {
    border: 1px solid #ff656c;
}

.register-block button {
    width: 100%;
    height: 40px;
    background: #ff656c;
    box-sizing: border-box;
    border-radius: 5px;
    border: 1px solid #e15960;
    color: #fff;
    font-weight: bold;
    text-transform: uppercase;
    font-size: 14px;
    font-family: Montserrat;
    outline: none;
    cursor: pointer;
}

.register-block button:hover {
    background: #ff7b81;
}
 </style> 
<body>
 <form:form action="store" method="post">	 
 <c:forEach var="e" items="${errors}">
		<li>${e.getDefaultMessage()}" </li>
	</c:forEach> 

	<!-- <div id="background-carousel">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <div class="carousel-inner">
        <div class="item active" style="background-image:url(.//resources/project/73.jpg)"></div>
        <div class="item" style="background-image:url(.//resources/project/101.jpg)"></div>
        <div class="item" style="background-image:url(.//resources/project/113.jpg)"></div>  
      </div>
    </div>
</div> -->
<div class="logo"></div>
<div class="register-block">
    <h1>Login</h1>
     <form:input path= 'mail' name="fieldUser" placeholder="username"   required="true" />
      <form:input path='firstname'  placeholder="first Name" name="UserRegistration[username]" 	require="true" />
     <form:input path='lastname'  placeholder="last Name" name="UserRegistration[username]" 	require="true" />   
    <form:input path='username' placeholder="first Name" name="UserRegistration[username]" 	require="true" />  
    <form:input path='password' name="fieldPassword"  type="password" placeholder="password" class="input" required="true" />
   <form:input path='mobile'  placeholder="Contact Number" name="UserRegistration[contactnumber]" required="true" />
     <button class="btn-u pull-left" type="submit">Sign Up</button>
	  
	
	
  <%--   <div class="col-md-3">
    <div class="col-md-6">
         <div class="row myborder">
             <h4 style="color: #7EB59E; margin: initial; margin-bottom: 10px;">Sign Up Now</h4><hr>
            <div class="input-group margin-bottom-20">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user mycolor"></i></span>
                <form:input path='firstname' size="60" maxlength="255" class="form-control" placeholder="first Name" name="UserRegistration[username]" 	require="true" />                                                    
                    </div>
                     <div class="input-group margin-bottom-20">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user mycolor"></i></span>
                <form:input path='lastname' size="60" maxlength="255" class="form-control" placeholder="last Name" name="UserRegistration[username]" 	require="true" />                                                    
                    </div>
                     <div class="input-group margin-bottom-20">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user mycolor"></i></span>
                <form:input path='username' size="60" maxlength="255" class="form-control" placeholder="first Name" name="UserRegistration[username]" 	require="true" />                                                    
                    </div>
                    <div class="input-group margin-bottom-20">
                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope mycolor"></i></span>
                <form:input path='mail' size="60" maxlength="255" class="form-control" placeholder="email" name="UserRegistration[password]"  require="true" />                                
                    </div>
                               
            <div class="input-group margin-bottom-20">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock mycolor"></i></span>
                <form:input path='password' size="60" maxlength="255" class="form-control" placeholder="Password" name="UserRegistration[password]" type="password" require="true" />                                
                    </div>
            
            <div class="input-group margin-bottom-20">
                <span class="input-group-addon"><i class="glyphicon glyphicon-phone mycolor"></i></span>
                 <form:input path='mobile' size="60" maxlength="255" class="form-control" placeholder="Contact Number" name="UserRegistration[contactnumber]" required="true" />                                    
                 </div>
                 
            <div class="row">
                <div class="col-md-12">
                    <button class="btn-u pull-left" type="submit">Sign Up</button>
                                   </div>
            </div>	
            </div>
            </div>
            </div>
 --%>             
 </div>
                                    
    </form:form>


</body>
</html>