<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>forum</title>
<style type="text/css">

<style>

</style> 
<body>
<form:form action="store2" method="post">	 
 <c:forEach var="e" items="${errors}">
		<li>${e.getDefaultMessage()}" </li>
	</c:forEach> <div id="form">

<div class="fish" id="fish"></div>
<div class="fish" id="fish2"></div>

<form id="waterform" method="post">

<div class="formgroup" id="name-form">
    <label for="name">Your name*</label>
    <form:input path='fname' name="fieldUser" placeholder="fname"  class="input" required="true" />
</div>

<div class="formgroup" id="email-form">
    <label for="email">Your Content*</label>
    <form:input path='fdesc' name="fieldUser" placeholder="fdesc"  class="input" required="true" />
</div>
<div class="formgroup" id="email-form">
    <label for="email">Your Content*</label>
    <form:input path='reason' name="fieldUser" placeholder="reason"  class="input" required="true" />
</div>

<div class="formgroup" id="email-form">
    <label for="email">Your Content*</label>
    <form:input path='author' name="fieldUser" placeholder="author"  class="input" required="true" />
 
</div>

      	<input type="submit" value="Add Forum!" />
</form>
	
    </form:form>
<div ng-app="myApp" ng-controller="dataCtrl">
Enter Event Name:  <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Description</th>
    <th>Reason</th>
    <th>Author</th>
    
    </tr>
        <tr ng-repeat="resource in names | filter:search">
             <td>{{resource.fid}}</td>
            <td>{{ resource.fname}}</td>
            <td>{{ resource.fdesc}}</td>
            <td>{{ resource.reason}}</td>
            <td>{{ resource.author}}</td>
           
            <!-- <td><img src="resources/images/{{resource.bid}}.jpg" style="width: 200px;height:150px"></td>
            <td><a href="deleteProduct?id={{resource.product_id}}">Delete</a></td> -->
        </tr>    
    </table>
</div>
<div>
<%-- ${blogs} --%>
</div>
<script>
$('document').ready(function(){
	$('input[type="text"], input[type="email"], textarea').focus(function(){
		var background = $(this).attr('id');
		$('#' + background + '-form').addClass('formgroup-active');
		$('#' + background + '-form').removeClass('formgroup-error');
	});
	$('input[type="text"], input[type="email"], textarea').blur(function(){
		var background = $(this).attr('id');
		$('#' + background + '-form').removeClass('formgroup-active');
	});

function errorfield(field){
	$(field).addClass('formgroup-error');
	console.log(field);	
}

$("#waterform").submit(function() {
	var stopsubmit = false;

if($('#name').val() == "") {
	errorfield('#name-form');
	stopsubmit=true;
}
if($('#email').val() == "") {
	errorfield('#email-form');
	stopsubmit=true;
}
  if(stopsubmit) return false;
});
		
});
</script>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${forums};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
</body>
</html>