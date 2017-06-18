<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js"></script>
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
	<script type="text/javascript">
//Wait for the DOM to be ready
$(document).ready(function () {

    $('#employeeAddForm').validate({ // initialize the plugin
        rules: {
        	userFirstName: {
                required: true,
               
            },
            userLastName: {
                required: true,
                minlength: 5
            }
            gender:{
            	required: true
            	
            }
        }
    });

});</script>
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


	<div class="container" id="EmployeeDisplayer">
		<div class="row">
			<div class="col-md-offset-5 col-md-3">
				<div class="form-login">
					<form:form modelAttribute="employee" id='employeeAddForm' name='employeeAddForm'
						action="/addInformation" method="post"
						 onsubmit="return validateUpdateform()">
						<input type="hidden" name="function" value="addRequest">
						<table>
							<tr>
								<td class="span4">Employee ID:</td>
								<td class="span3">${requestScope.employeeNo}<form:hidden
										path="employeeNo" id="userUpdateID" name="userUpdateID"
										class="form-control input-sm chat-input" placeholder="User ID"></form:hidden>
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
								<td><form:input path="lastName" id="userLastName"
										name="userLastName" class="form-control input-sm chat-input"
										placeholder="Last Name" /></td>

							</tr>
							<tr>
								<td>Date of Birth:</td>
								<td><form:input path="birthDate" id="dateOfBirth"
										name="dateOfBirth" class="form-control input-sm chat-input"
										placeholder="Date of Birth" /></td>
							</tr>
							<tr>
								<td>Date of Hire</td>
								<td><form:input path="hireDate" id="hireDate"
										name="hireDate" class="form-control input-sm chat-input"
										placeholder="Hiring Date" /></td>
							</tr>
							<tr>
								<td>Gender</td>
								<td><form:input type="text" path="gender" id="gender"
										name="gender" class="form-control input-sm chat-input"
										placeholder="M/F" /></td>
							</tr>
							<tr colspan="2">
								<td><input type="submit" id="submit"
									class="btn btn-default" value="Add Employee"></td>
							</tr>
						</table>
					</form:form>
					<span class="label label-success">${requestScope.message}</span>
				</div>

			</div>
		</div>
</body>

</html>