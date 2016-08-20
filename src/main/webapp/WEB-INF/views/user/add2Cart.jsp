<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add to Cart</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style type="text/css">
h1 {
	margin: 30px 0;
	padding: 0 200px 15px 0;
	border-bottom: 1px solid #E5E5E5;
}

.bs-example {
	margin: 20px;
}
</style>

</head>
<body>
	<%@ include file="usernavbar.jsp"%>

	<div class="bs-example">
		<h1>Add Product to Cart</h1>
		<form:form method="POST" commandName="cmd_save2Cart"
			action="save2Cart">
			<table>
				<tr>
					<td><img src="${cartrow.getImgPath()}" height="300px"
						width="300px" /></td>
					<td>
						<div class="col-sm-8">
							<form:label path="ProductId">Product Id:</form:label>
							<br />
							<form:input path="ProductId" readonly="true"
								value="${cartrow.getId()}" size="50" />
							<br />
						</div>
						<div class="col-sm-8">
							<form:label path="PrdName">Product Name:</form:label>
							<br />
							<form:input path="PrdName" readonly="true"
								value="${cartrow.getPrdName()}" size="50" />
							<br />
							<form:errors path="PrdName" cssClass="error" />
							<br />
						</div>
						<div class="col-sm-8">
							<form:label path="Price">Product Price:</form:label>
							<br />
							<form:input path="Price" readonly="true"
								value="${cartrow.getPrice()}" size="70" />
							<br />
							<form:errors path="Price" cssClass="error" />
							<br />
						</div>

						<div class="col-sm-8">
							<form:label path="Warranty">Product Warranty:</form:label>
							<br />
							<form:input path="Warranty" readonly="true"
								value="${cartrow.getWarranty()}" size="70" />
							<br />
							<form:errors path="Warranty" cssClass="error" />
							<br />
						</div>
						<div class="col-sm-8">
							<form:label path="Discount">Product Discount:</form:label>
							<br />
							<form:input path="Discount" readonly="true"
								value="${cartrow.getDiscount()}" size="70" />
							<br />
							<form:errors path="Discount" cssClass="error" />
							<br />
						</div>
						<div class="col-sm-8">
							<form:label path="Quantity">Product Quantity:</form:label>
							<br />
							<form:input path="Quantity" value="1"
								size="70" />
							<br />
							<form:errors path="Quantity" cssClass="error" />
							<br />
						</div>
						<div class="col-sm-8">
							<a href="<c:url value='/ulp1?cat=u${cartrow.getCategory()}'/>"
								class="btn btn-info" role="button">Back</a> &nbsp;&nbsp; 
							<input class="btn btn-info" type="submit" value="Confirm Product" /><br />
						</div>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>