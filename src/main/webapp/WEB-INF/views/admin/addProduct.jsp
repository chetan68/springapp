<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>Add Product Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type="text/javascript">
	function Validate() {

		var image = document.getElementById("image").value;
		if (image != '') {
			var checkimg = image.toLowerCase();
			if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)) {
				alert("Please enter Image File Extensions .jpg,.png,.jpeg");
				document.getElementById("image").focus();
				return false;
			}
		}
		return true;
	}
</script>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>

</head>
<body>
<%@ include file="adminnavbar.jsp" %>
	<div class="container">

		<h2>Add Product Form</h2>
		<form:form method="POST" commandName="cmdProduct" action="saveProduct"
			enctype="multipart/form-data">

			<div class="form-group">
				<div class="col-sm-8">
					<form:label path="PrdName">Product Name:</form:label>
					<br />
					<form:input path="PrdName" size="50" />
					<br />
					<form:errors path="PrdName" cssClass="error" />
				</div>
				<div class="col-sm-8">
					<form:label path="Price">Product Price:</form:label>
					<br />
					<form:input path="Price" size="50" />
					<br />
					<form:errors path="Price" cssClass="error"/>
				</div>

				<div class="col-sm-8">
					<form:label path="Category">Product Category:</form:label>
					<br />
					<form:select path="Category">
						<form:option value="camera" label="Camera" />
						<form:option value="ehdd" label="External Hard Drive" />
						<form:option value="tablet" label="Tablet" />
					</form:select>
				</div>

				<div class="col-sm-8">
					<form:label path="Warranty">Product Warranty (years):</form:label>
					<br />
					<form:select path="Warranty">
						<form:option value="1" label="1" />
						<form:option value="2" label="2" />
						<form:option value="3" label="3" />
					</form:select>
				</div>

				<div class="col-sm-8">
					<form:label path="Discount">Product Discount:</form:label>
					<br />
					<form:select path="Discount">
						<form:option value="2.5" label="2.5" />
						<form:option value="5" label="5" />
						<form:option value="7.5" label="7.5" />
					</form:select>
				</div>
				<div class="col-sm-8">
					<form:label path="ImgPath">Image Path:</form:label>
					<br /> <input type="file" name="mpartFile" /><br />
				</div>

				<div class="col-sm-8">
					<button type="submit" class="btn btn-success">Submit</button>
					<br />
				</div>
			</div>
		</form:form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>

