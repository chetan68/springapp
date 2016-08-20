<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Modify Product Entry</title>
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
	<div class="bs-example">
		<h1>Modify Product Entry</h1>
		<table>
			<tr>
				<td><img src="${editrow.getImgPath()}" height="350px"
					width="350px" /></td>
				<td> 
				<form:form method="POST" commandName="cmd_save_editedProduct" action="saveEditedProduct">
						<div class="form-group">
							<div class="col-sm-8">
								<form:label path="id">Product Id:</form:label>
								<br />
								<form:input path="id" readonly="true" value="${editrow.getId()}"
									size="50" />
								<br />
								
								<br />
							</div>
							<div class="col-sm-8">
								<form:label path="PrdName">Product Name:</form:label>
								<br />
								<form:input path="PrdName" value="${editrow.getPrdName()}"
									size="50" />
								<br />
								<form:errors path="PrdName" cssClass="error" />
								<br />
							</div>
							<div class="col-sm-8">
								<form:label path="Price">Product Price:</form:label>
								<br />
								<form:input path="Price" value="${editrow.getPrice()}" size="70" />
								<br />
								<form:errors path="Price" cssClass="error" />
								<br />
							</div>
							<div class="col-sm-8">
								<form:label path="Category">Product Category:</form:label>
								<br />
								<form:input path="Category" value="${editrow.getCategory()}"
									size="70" />
								<br />
								<form:errors path="Category" cssClass="error" />
								<br />
							</div>
							<div class="col-sm-8">
								<form:label path="Warranty">Product Warranty:</form:label>
								<br />
								<form:input path="Warranty" value="${editrow.getWarranty()}"
									size="70" />
								<br />
								<form:errors path="Warranty" cssClass="error" />
								<br />
							</div>
							<div class="col-sm-8">
								<form:label path="Discount">Product Discount:</form:label>
								<br />
								<form:input path="Discount" value="${editrow.getDiscount()}"
									size="70" />
								<br />
								<form:errors path="Discount" cssClass="error" />
								<br />
							</div>
							<div class="col-sm-8">
								<form:label path="ImgPath">Image Path:</form:label>
								<br /> 
								<form:input path="ImgPath" type="file"  name="mpartFile" value="${editrow.getImgPath()}"/>
								<br />
								<br />
							</div>
							<div class="col-sm-8">
								<input type="submit" value="Submit" /><br />
							</div>
						</div>
					</form:form></td>
			</tr>
		</table>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
