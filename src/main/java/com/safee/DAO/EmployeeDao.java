package com.safee.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.safee.DAO.interfaces.EmployeeDaoInterface;
import com.safee.controller.EmployeeController;
import com.safee.model.Employee;

public class EmployeeDao implements EmployeeDaoInterface {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDao.class);
	@Override
	public Employee getEmployee(int empId) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		try (Connection connection = JdbcConnectionFactory.getConnection();) {
			String SQL = "Select * from EMPLOYEES WHERE emp_no=?";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeNo(resultSet.getInt("emp_no"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setBirthDate(format.parse(resultSet.getDate("birth_date").toString()));
				employee.setHireDate(format.parse(resultSet.getDate("hire_date").toString()));
				employee.setGender(resultSet.getString("gender"));
				return employee;
			}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateEmployee(Employee employee) {

		// TODO Auto-generated method stub
		try (Connection connection = JdbcConnectionFactory.getConnection();) {
			String SQL = "UPDATE employees SET first_name=?, last_name=?, birth_date=?, hire_date=? where emp_no=?";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(employee.getBirthDate().getTime()));
			preparedStatement.setDate(4, new java.sql.Date(employee.getHireDate().getTime()));
			preparedStatement.setInt(5, employee.getEmployeeNo());
			logger.debug(preparedStatement.toString());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Integer getNewEmployeeID() {
		// TODO Auto-generated method stub
		try (Connection connection = JdbcConnectionFactory.getConnection()) {
			String SQL = "SELECT MAX(emp_no) FROM employees";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				logger.debug("Generated ID:"+(Integer) (resultSet.getInt(1) + 1));
				return (Integer) (resultSet.getInt(1) + 1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug("No ID generated");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try (Connection connection = JdbcConnectionFactory.getConnection()) {
			String SQL = "INSERT INTO EMPLOYEES (emp_no, birth_date, first_name,last_name,gender,hire_date) VALUES (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, employee.getEmployeeNo());
			preparedStatement.setDate(2, new java.sql.Date(employee.getBirthDate().getTime()));
			preparedStatement.setString(3, employee.getFirstName());
			preparedStatement.setString(4, employee.getLastName());
			preparedStatement.setString(5, employee.getGender());
			preparedStatement.setDate(6, new java.sql.Date(employee.getHireDate().getTime()));
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
