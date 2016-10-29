<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
</head>
<body>
<link href="http://getbootstrap.com/examples/jumbotron-narrow/jumbotron-narrow.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">
<div class="container bootstrap snippet">

  <div class="header">
    <h3 class="text-muted prj-name">
        <span class="fa fa-users fa-2x principal-title"></span>
        Friend zone
    </h3>
  </div>

<tr ng-repeat="resource in names | filter:search">
  <div class="jumbotron list-content">
    <ul class="list-group">
    	<li href="#" class="list-group-item title">
        Your friend zone
        </li>
      </ul>
      <li href="#" class="list-group-item text-left">
        <img class="img-thumbnail" src="http://bootdey.com/img/Content/User_for_snippets.png">
        <label class="name">
           {{resource.username}}<br>
        </label>
        <label class="pull-right">
            <a  class="btn btn-success btn-xs glyphicon glyphicon-ok" href="#" title="View"></a>
            <a  class="btn btn-danger  btn-xs glyphicon glyphicon-trash" href="#" title="Delete"></a>
            <a  class="btn btn-info  btn-xs glyphicon glyphicon glyphicon-comment" href="#" title="Send message"></a>
        </label>
        <div class="break"></div>
      </li>
      <li href="#" class="list-group-item text-left">
          <img class="img-thumbnail"  src="http://bootdey.com/img/Content/user_1.jpg">
        <label class="name">
          James Rodriguez (10)
        </label>
        <label class="pull-right">
            <a  class="btn btn-success btn-xs glyphicon glyphicon-ok" href="#" title="View"></a>
            <a  class="btn btn-danger  btn-xs glyphicon glyphicon-trash" href="#" title="Delete"></a>
            <a  class="btn btn-info  btn-xs glyphicon glyphicon glyphicon-comment" href="#" title="Send message"></a>
        </label>
        <div class="break"></div>
      </li>
      <li href="#" class="list-group-item text-left">
          <img class="img-thumbnail"  src="http://bootdey.com/img/Content/user_2.jpg">
          <label class="name">
            Mariana pajon
          </label>
        <label class="pull-right">
            <a  class="btn btn-success btn-xs glyphicon glyphicon-ok" href="#" title="View"></a>
            <a  class="btn btn-danger  btn-xs glyphicon glyphicon-trash" href="#" title="Delete"></a>
            <a  class="btn btn-info  btn-xs glyphicon glyphicon glyphicon-comment" href="#" title="Send message"></a>
        </label>
        
        <div class="break"></div>
      </li>
      </tr>
      <li href="#" class="list-group-item text-left">
        <a class="btn btn-block btn-primary">
            <i class="glyphicon glyphicon-refresh"></i>
            Load more...
        </a>
      </li>
  
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