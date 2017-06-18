package com.safee.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.safee.DAO.interfaces.DepartmentDaoInterface;
import com.safee.model.Department;

public class DepartmentDao implements DepartmentDaoInterface {

	@Override
	public Department getDepartment(int empId) {
		try (Connection connection = JdbcConnectionFactory.getConnection();) {
			String SQL = "SELECT dept_emp.dept_no, departments.dept_name  from dept_emp INNER JOIN departments ON dept_emp.dept_no=departments.dept_no where emp_no=? ;";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Department department = new Department();
				department.setDepName(resultSet.getString("dept_name"));
				department.setDeptNo(resultSet.getString("dept_no"));
				return department;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
