<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome to Murti Mant</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<%@ include file="navbar.jsp"%>

	<div id="myCarousel" class="carousel slide" data-ride="carousel"
		data-interval="2000">
		<ol class="carousel-indicators">
			<li data-target="myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="myCarousel" data-slide-to="1"></li>
			<li data-target="myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">


				<img src="resources/images/cameras/carsoulcamera.jpg" width="735px"
					height="735px">
			</div>


			<div class="item">
				<img src="resources/images/cameras/carouselhard-drive-crash-2.jpg"
					width="735px" height="735px" alt="">
			</div>

			<div class="item">
				<img src="resources/images/cameras/carsoultablets.jpg" width="735px"
					height="735px" alt="">
			</div>


		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<!--  <a href="search?data=camera"> -->
				<a href="<c:url value='/listProducts?cat=ehdd'/>"> <img
					src="<c:url value="/resources/images/ehdds/ehdddell.jpg"/>"
					alt="External Hard Drive" style="width: 300px; height: 150px">
				</a>
			</div>
			<div class="col-sm-4">
				<a href="<c:url value='/listProducts?cat=camera'/>"> <img
					src="<c:url value="/resources/images/image2.jpg"/>" alt="Camera"
					style="width: 300px; height: 150px">
				</a>
			</div>
			<div class="col-sm-4">
				<a href="<c:url value='/listProducts?cat=tablet'/>"> <img
					src="<c:url value="/resources/images/tablets/tablets (3).jpg"/>"
					alt="Tablet" style="width: 300px; height: 150px">
				</a>
			</div>
		</div>
	</div>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</body>
</html>
