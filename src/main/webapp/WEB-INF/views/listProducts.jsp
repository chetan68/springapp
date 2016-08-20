<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Products</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href='<c:url value="resources/css/bootstrap.min.css"/>'>
<script src="<c:url value="resources/js/bootstrap.min.js"/>"></script>
</head>

<body>
	<%
		response.setIntHeader("Refresh", 180);
	%>
	<%
		String str = request.getParameter("cat");
	%>

	<%@ include file="navbar.jsp"%>
<div class="container">
			<div class="container" style="margin-top: 4%" ng-app="tabApp"
				ng-controller="tabCtrl">
				
		<span>&nbsp;</span>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th></th>
							<th>Id</th>
							<th>Product Name</th>
							<th>Price</th>
							<th>Discount</th>
							<th>Warranty</th>
							<th>Category</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="x in data">
							<td><img src={{x.ImgPath}} height="50px" width="50px" /></td>
							<td>{{x.id}}</td>
							<td>{{x.PrdName}}</td>
							<td>{{x.Price}}</td>
							<td>{{x.Discount}}</td>
							<td>{{x.Warranty}}</td>
							<td>{{x.Category}}</td>
							<td><a href="view?id={{x.id}}" class="btn btn-info" role="button">Details</a> </td>
						</tr>
					</tbody>
				</table>
				
			</div>
			<script>
				var app = angular.module('tabApp', []);
				app.controller('tabCtrl', function($scope, $http) {
					$http.get("<%=str%>").then(function(response) {
						$scope.data = response.data
					})
				});
			</script>
		</div>

	
	
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
<script src="<c:url value="resources/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="resources/js/angular.min.js"/>"></script>

<script>
				var app = angular.module('tabApp', []);
				app.controller('tabCtrl', function($scope, $http) {
					$http.get("<%=str%>").then(function(response) {
				$scope.data = response.data
			})
		});
	</script>
	<!--  angular form o -->
</body>
</html>