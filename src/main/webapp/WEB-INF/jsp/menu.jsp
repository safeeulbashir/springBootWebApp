<div
	style='float: left; width: 300px; height: 500px; border-style: solid; border-color: blue; background-color: #eeeeee;'>
	<ul>
		<li><a href='#'><font size='5'>Product</font></a>
			<ul>
				<li><a href="<%= request.getContextPath() %>/RequestHandler?requestAction=VIEW_EMPLOYEE">View Employee</a></li>
				<li><a href="<%= request.getContextPath() %>/RequestHandler?requestAction=UPDATE_EMPLOYEE">Update Employee</a></li>
				<li><a href="<%= request.getContextPath() %>/RequestHandler?requestAction=GENERATE_EMPLOYEE">Add Employee</a></li>
			</ul></li>
	</ul>
</div>
