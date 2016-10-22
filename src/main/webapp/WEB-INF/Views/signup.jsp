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
<style>
/* carasouel style*/
 html,body {
    height:100%;
    width:100px;
    position:absolute;
   text-align: center;
} 
 #background-carousel{
	position:fixed;
	width:100%;
	height:100%;
	z-index:-1;
	width: 300px;
    margin: 0 auto;
}
.carousel,
.carousel-inner {
	width:100%;
	height:100%;
	z-index:0;
	overflow:hidden;
}
.item {
	width:100%;
	height:100%;
	background-position:center center;
	background-size:cover;
	z-index:0;
} 


  .mycolor{
            color : #72c02c;
        }  
        //size of the text boxes       
        .myborder{
            padding: 20px;;
            border: 1px solid #ccc;
            border-radius: 4px;
            -webkit-box-shadow: 0px 0px 3px 0px #72c02c;
            -moz-box-shadow:    0px 0px 3px 0px #72c02c;
            box-shadow:         0px 0px 3px 0px #72c02c;
        } 
         .mybutton{
            position: relative;
            left: 20PX;
            top: 193px;

        }
        //size of the total box
        .margin-bottom-20 {
            margin-bottom: 30px;

        }
        .btn-u:hover {
            background: #5fb611;
        }
        .btn-u:hover, .btn-u:focus, .btn-u:active, .btn-u.active, .open .dropdown-toggle.btn-u {
            background: #5fb611;
        } 
      .btn-u:hover {
            color: #fff;
            text-decoration: none;
            -webkit-transition: all 0.3s ease-in-out;
            -moz-transition: all 0.3s ease-in-out;
            -o-transition: all 0.3s ease-in-out;
            transition: all 0.3s ease-in-out;
        }
        //this code is for sign up button
        .btn-u {
            background: #72c02c;
        }
        .btn-u {
            white-space: nowrap;
            border: 0;
            color: #fff;
            font-size: 14px;
            cursor: pointer;
            font-weight: 400;
            padding: 6px 13px;
            position: relative;
            background: #72c02c;
            display: inline-block;
            text-decoration: none;
        }
        //this code is for icons 
        .input-group-addon {
            border-right: 0;
            color: #b3b3b3;
            font-size: 14px;
            background: #fff;
            padding: 6px 100px;
            font-size: 14px;
            font-weight: 400;
            line-height: 1;
            color: #555;
            text-align: center;
            background-color: #eee;
            border: 1px solid #ccc;
            border-radius: 4px;
        } 
         .input-group .form-control {
            float: center;
            width: 100px;
            margin-bottom: 0;
        }
        .form-control {
            box-shadow: none;
        } 
         .form-control {
            display: block;
            width: 100PX;
            height: 34px !important;
            padding: 6px 12px;
            font-size: 14px;
            line-height: 1.428571429;
           
            background-image: none;
            border: 1px solid  #72c02c !important;
            border-radius: 4px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            -webkit-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
        }


 
 </style> 
<body>
 <form:form action="store" method="post">	 
 <c:forEach var="e" items="${errors}">
		<li>${e.getDefaultMessage()}" </li>
	</c:forEach> 

	<div id="background-carousel">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <div class="carousel-inner">
        <div class="item active" style="background-image:url(.//resources/project/73.jpg)"></div>
        <div class="item" style="background-image:url(.//resources/project/101.jpg)"></div>
        <div class="item" style="background-image:url(.//resources/project/113.jpg)"></div>  
      </div>
    </div>
</div>
	
	
    <div class="col-md-3">
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
                                                
    </form:form>


</body>
</html>