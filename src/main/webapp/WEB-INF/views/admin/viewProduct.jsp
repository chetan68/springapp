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
<link rel="stylesheet"
	href='<c:url value="resources/css/bootstrap.min.css"/>'>
<script src="<c:url value="resources/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="resources/js/angular.min.js"/>"></script>
<script src="<c:url value="resources/js/bootstrap.min.js"/>"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
</head>
<body>
	<%
		String str = request.getParameter("id");
	%>
	<%@ include file="adminnavbar.jsp"%>

	<div class="container">
		<table width="70%" align="center" border="0">
			<tr>
				<td><img src=${viewrow.getImgPath()
							}
					alt=${viewrow.getCategory() } width="500px" height="400px" /></td>
				<td>&nbsp;</td>
				<td><h3>
						Product ID: ${viewrow.getId()}</br> Name: ${viewrow.getPrdName()}</br>
						Price: ${viewrow.getPrice()}</br> Discount: ${viewrow.getDiscount()}</br>
						Warranty: ${viewrow.getWarranty()}</br>
					</h3></td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3" align="center"> 
				<a href="adlp1?cat=ad${viewrow.getCategory()}"
					class="btn btn-info" role="button">Back</a> </td>
			</tr>
		</table>
	</div>
</body>
</html>