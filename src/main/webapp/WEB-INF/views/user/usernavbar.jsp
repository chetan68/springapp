<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Murti Mant
				&nbsp;&nbsp;</a>
		</div>
		<button class="navbar-toggle" data-toggle="collapse"
			data-target=".navHeaderCollapse">

			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>

		<div class="collapse navbar-collapse navHeaderCollapse">
			<ul class="nav navbar-nav navbar-right">
				<li class="nav navbar-brand">Welcome, ${message} </li>
				<li><a href="<c:url value='/ulp1?cat=uall'/>">View Products</a></li>
				<li><a href="<c:url value='/welcome?logout' />"> <span
						class="glyphicon glyphicon-user"></span> Sign Out
				</a></li>
			</ul>
		</div>
	</div>
</nav>