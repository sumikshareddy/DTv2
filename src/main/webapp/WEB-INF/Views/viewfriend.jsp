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
<link href="http://getbootstrap.com/examples/jumbotron-narrow/jumbotron-narrow.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
 
  <script>document.write('<base href="' + document.location + '" />');</script>
    <script data-require="angular.js@1.0.x" src="http://code.angularjs.org/1.0.7/angular.min.js" data-semver="1.0.7"></script>
<title>viewFRIENDS</title>
</head>
<style>
.list-content{
 min-height:300px;
}
.list-content .list-group .title{
  background:#5bc0de;
  border:2px solid #DDDDDD;
  font-weight:bold;
  color:#FFFFFF;
}
.list-group-item img {
    height:80px; 
    width:80px;
}

.jumbotron .btn {
    padding: 5px 5px !important;
    font-size: 12px !important;
}
.prj-name {
    color:#5bc0de;    
}
.break{
    width:100%;
    margin:20px;
}
.name {
    color:#5bc0de;    
}

</style>
<body ng-app="myApp">
<div class="container bootstrap snippet">
<div class="jumbotron list-content">
<div ng-controller="dataCtrl">
<table class="table table-striped">
    <tr>
    
    <th>Name</th>
    <th>Status</th>
    
   
    </tr>
        <tr ng-repeat="resource in names | filter:search">
            <!-- <td>{{resource.uid}}</td>
 -->            <td>{{ resource.username}}</td>
            <!-- <td>{{ resource.mail}}</td>
            <td>{{ resource.mobile}}</td> -->
            <td> <a href="addasfriend?u={{resource.uid}}" class="button" role="button">sendrequest</a>                        <!-- <td><img src="resources/images/{{resource.bid}}.jpg" style="width: 200px;height:150px"></td>
            <td><a href="deleteProduct?id={{resource.product_id}}">Delete</a></td> -->
           
        </tr>    
    </table>
</div>
<%-- <div>
    <table class="table table-striped">
    <tr>
    
    <th>name</th>
    
   
    </tr>
		<c:forEach var="frd" items= "${friendRequests}">
        <tr>
            
            <td>${frd.getFriend()}</td>
           
 --%>           <%--   <td> <a href="acceptfriend?f=${frd.getReqid()}"<!--  class="button" role="button">accept</a> -->
 --%>            
         </tr> 
        <%-- </c:forEach>    --%>
    </table> 
    </div>
    </div>
    
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${users};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});

</script>


</body>
</html>