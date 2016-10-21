<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js" ></script>
  	<script>document.write('<base href="' + document.location + '" />');</script>
  	<style type="text/css">
  		.container,.jumbotron{
  			width:100%;
  		}
  		.content{
  			width:75%;
  			float: right;
  		}
  		table tr td,table tr th{
  			text-align: center;
  		}
  	</style>
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<br/>
<div class="container">
  	<div class="jumbotron">
    	<h2>Blogs<span class="badge">${bcount}</span></h2>      
  	</div>
  		<div class="content" ng-app="myApp" ng-controller="namesCtrl">
			<form>
				<input type="text" ng-model="search"/>&nbsp&nbsp
				<span class="glyphicon glyphicon-search"></span>
			</form>
			<br/>
			<table class="table table-striped">
				<tr>
					<th>NAME</th>
					<th>Created On</th>
				</tr>
				<tr ng-repeat="resource in names | filter:search">
  					<td>{{ resource.blogName}}</td>
					<td><a href="Blog?b={{ resource.blogId}}">{{ resource.createdDate}}</a></td>
				</tr>
			</table>
			<script>
				angular.module('myApp', []).controller('namesCtrl', function($scope) {
    				$scope.names = ${blogs};
    				$scope.orderByMe = function(x) {
        				$scope.myOrderBy = x;
    				}
				});
			</script>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>