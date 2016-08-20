<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Cart</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet"
	href='<c:url value="resources/css/bootstrap.min.css"/>'>
<script src="<c:url value="resources/js/bootstrap.min.js"/>"></script>
</head>

<body>
	<%
		response.setIntHeader("Refresh", 180);
	%>
	<%
		String str = "1";  //request.getParameter("cat");
	%>

	<%@ include file="usernavbar.jsp"%>
	<div class="container">
		<div class="container" style="margin-top: 4%" ng-app="tabApp"
			ng-controller="tabCtrl">

			<span>&nbsp;</span>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th></th>
						<th>Cart Item Id</th>
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Unit Price</th>
						<th>Discount</th>
						<th>Warranty</th>
						<th>Quantity</th>
						<th>CartAmount</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="x in data">
						<td><img src={{x.ImgPath}} height="50px" width="50px" /></td>
						<td>{{x.CartId}}</td>
						<td>{{x.ProductId}}</td>
						<td>{{x.PrdName}}</td>
						<td>{{x.Price}}</td>
						<td>{{x.Discount}}</td>
						<td>{{x.Warranty}}</td>
						<td>{{x.Quantity}}</td>
						<td>{{x.CartAmount}}</td>
					</tr>
					<tr>
						<td colspan=9>&nbsp;</td>
					</tr>
					<tr>
						<td colspan=9><a href="<c:url value='/ulp1?cat=uall'/>"
							class="btn btn-info" role="button">New Product</a> <a
							href="<c:url value='/payment'/>" class="btn btn-info"
							role="button">Make Payment</a></td>
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

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
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
	
</body>
</html>