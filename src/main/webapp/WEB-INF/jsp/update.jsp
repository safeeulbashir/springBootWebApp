<%-- <%@page import="webappservice.EmployeeServices"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Bare - Start Bootstrap Template</title>

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
<script type="text/javascript">
	function validateform() {
		var userID = document.getElementById('userID').value;
		if (userID == '') {
			alert('please enter user id');
			return false;
		}
		document.getElementById('employeeDisplayForm').action = "/updateEmployee/"
				+ document.getElementById('userID').value;
	}

	function validateUpdateform() {
		if (document.getElementById('userFirstName').value == ''
				|| document.getElementById('userLastName').value == ''
				|| document.getElementById('userSalary'))
			return false;
		alert("Comming here");
		document.getElementById('employeeUpdateForm').submit();

	}
</script>

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
					<form id='employeeDisplayForm' action="" method="post"
						onsubmit="return validateform()">
						<input type="hidden" name="function" value="displayForUpdate">
						<input type="text" id="userID" name="userID"
							class="form-control input-sm chat-input" placeholder="User ID" />
						<div class="wrapper">
							<input type="submit" id="submit" class="btn btn-default"
								value="Search">
						</div>
				</div>
				</form>
			</div>

		</div>
	</div>
	<div class="container" id="EmployeeDisplayer">
		<div class="row">
			<div class="col-md-offset-5 col-md-3">
				<div class="form-login">
					<form:form id='employeeUpdateForm'
						onsubmit="return validateUpdateform()"
						action="/updateEmployeeInformation" method="POST"
						modelAttribute="employee">

						<input type="hidden" name="function" value="updateRequest">
						<table>
							<tr>
								<td class="span4">Employee ID:</td>
								<td class="span3">${requestScope.employee.getEmployeeNo()}<form:hidden
										path="employeeNo" id="userUpdateID" name="userUpdateID"
										placeholder="User ID"></form:hidden>
								</td>

							</tr>
							<tr>
								<td>First Name:</td>
								<td class="span4"><form:input path="firstName"
										id="userFirstName" name="userFirstName"
										class="form-control input-sm chat-input"
										placeholder="First Name" /></td>

							</tr>
							<tr>
								<td>Last Name:</td>
								<td><form:input path="lastName" id="userL"
										name="userLastName" class="form-control input-sm chat-input"
										placeholder="Last Name" /></td>

							</tr>
							<tr>
								<td>Birth Date</td>
								<td><form:input path="birthDate" id="userBirthDate"
										name="userBirthDate"
										class="form-control input-sm chat-input"
										placeholder="Birth Date" /> </td>
							</tr>
							<tr>
								<td>Joining Date</td>
								<td><form:input path="hireDate" id="userJoiningDate"
										name="userJoiningDate"
										class="form-control input-sm chat-input"
										placeholder="Joining Date" /> </td>
							</tr>
							<tr>
								<td>Gender</td>
								<td><form:input path="gender" id="userJoiningDate"
										name="userGender"
										class="form-control input-sm chat-input"
										placeholder="M/F" /></td>
							</tr>
							<tr colspan="2">
								<td><input type="submit" id="submit"
									class="btn btn-default" value="Update"></td>
							</tr>
						</table>
					</form:form>

					<span class="label label-success">${requestScope.message}</span>
				</div>

			</div>
		</div>
</body>
</html>
