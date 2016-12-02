<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <script>document.write('<base href="' + document.location + '" />');</script>
    <script data-require="angular.js@1.0.x" src="http://code.angularjs.org/1.0.7/angular.min.js" data-semver="1.0.7"></script>
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
<title>Event</title>
<style type="text/css">

</style> 
<body>
<form:form action="storeevent">
		<table>
			<tr>
				
				<td><form:label path="ename">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="ename" required="true" /></td>
			</tr>
			
			<tr>
				<td><form:label path="edesc">
						<spring:message text="Desc" />
					</form:label></td>
				<td><form:input path="edesc" required="true" /></td>
			</tr>
	       
    <tr>
				<td colspan="2">
						<input type="submit" value="<spring:message text="add event"/>" />
				</td>

			</tr>
			</table>
</form:form>
<div ng-app="myApp" ng-controller="dataCtrl">
Enter Event Name:  <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Description</th>
    
    </tr>
        <tr ng-repeat="resource in names | filter:search">
             <td>{{resource.eid}}</td>
            <td>{{ resource.ename}}</td>
            <td>{{ resource.edesc}}</td>
           
            <!-- <td><img src="resources/images/{{resource.bid}}.jpg" style="width: 200px;height:150px"></td>
 -->            <td><a href="deleteevent?id={{resource.event_id}}">Delete</a></td> 
        </tr>    
    </table>
</div>
<div>
<%-- ${blogs} --%>
</div>   
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${events};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
</body>
</html>