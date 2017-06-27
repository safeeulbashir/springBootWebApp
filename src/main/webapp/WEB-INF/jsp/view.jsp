<%-- <%@page import="webappservice.EmployeeServices"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Bare - Start Bootstrap Template</title>
<script type="text/javascript">
	function validateform() {
		var userID = document.getElementById('userID').value;
		if (userID == '') {
			alert('please enter user id');
			return false;
		}
		document.getElementById('employeeDisplayForm').action = "/viewEmployee/"
				+ document.getElementById('userID').value;
	}
</script>
<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Custom CSS -->
<style>
body {
	padding-top: 70px;
	/* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
}
</style>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Welcome</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="<%=request.getContextPath()%>/viewEmployee">View
							Employee</a></li>
					<li><a href="<%=request.getContextPath()%>/updateEmployee">Update
							Employee</a></li>
					<li><a href="<%=request.getContextPath()%>/addEmployee">Add
							Employee</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->

	<div class="container">
		<div class="row">
			<div class="col-md-offset-5 col-md-3">
				<div class="form-login">
					<h4></h4>
					<h4>Display Employee</h4>
					<form id='employeeDisplayForm' action="#"
						onsubmit="return validateform()" method="post">
						<input type="hidden" name="function" value="display"> <input
							type="text" id="userID" name="userID"
							class="form-control input-sm chat-input" placeholder="userID" />
						<div class="wrapper">
							<input type="submit" id="submit" class="btn btn-default"
								value="Search">
						</div>
				</div>
				</form>
				<table class="table table-bordered">
					<tr>
						<td class="span4">First Name</td>
						<td class="span3">${requestScope.employee.getFirstName()}</td>

					</tr>
					<tr>
						<td>Last Name</td>
						<td>${requestScope.employee.getLastName()}</td>

					</tr>
					<tr>
						<td>Birth Date</td>
						<td>${requestScope.employee.getBirthDate()}</td>
					</tr>
					<tr>
						<td>Hiring Date</td>
						<td>${requestScope.employee.getHireDate()}</td>
					</tr>
					<tr>
						<td>Gender</td>
						<td>${requestScope.employee.getGender()}</td>
					</tr>
					<c:forEach items="${requestScope.employee.getAddresses()}"  var="address" >
    				<tr>
						<td>Address</td>
						<td>${address.getLine1()}<br>
							${address.getLine2()}<br>
							${address.getCity()},${address.getState()}-${address.getZip()}
						</td>
					</tr>
					</c:forEach>
					<tr>
						<td>Salary</td>
						<td>${requestScope.employee.getSalary().getSalary()}</td>
					</tr>
				</table>
				<input type="button" id="submit" class="btn btn-default"
					value="Update" onclick="doUpdate()">
			</div>
			<span class="label label-success">${requestScope.message}</span>
		</div>
	</div>

</body>
</html>
