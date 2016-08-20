<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body onload='document.f.j_username.focus();'>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ include file="usernavbar.jsp"%>
	<div class="container">

		<h2>Login Form</h2>
		<font color="red"> <span>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
		</font>
		<form class="form-horizontal" name="f"
			action="j_spring_security_check" method="POST">
			<div class="form-group">
				<label class="control-label col-sm-2">User Name:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="j_username"
						placeholder="Enter User Name" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Password:</label>
				<div class="col-sm-3">
					<input type="password" class="form-control" name="j_password"
						placeholder="Enter password" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
					<button type="reset" class="btn btn-default">Reset</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>