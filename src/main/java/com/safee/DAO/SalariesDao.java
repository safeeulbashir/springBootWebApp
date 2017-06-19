package com.safee.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.safee.model.Salaries;

public class SalariesDao {
	public Salaries getSalaries(int empId) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		try (Connection connection = JdbcConnectionFactory.getConnection();) {
			String SQL = "Select * from SALARIES WHERE emp_no=? ORDER BY from_date, to_date DESC";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Salaries salaries = new Salaries();
				salaries.setEmployeeNo(resultSet.getInt("emp_no"));
				salaries.setSalary(resultSet.getInt("salary"));
				salaries.setFromDate(format.parse(resultSet.getDate("from_date").toString()));
				salaries.setToDate(format.parse(resultSet.getDate("to_date").toString()));
				System.out.println("No exception happend"+ salaries.getFromDate());
				return salaries;
			}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return null;
	}

	public void updateSalary(Salaries salaries) {
		// TODO Auto-generated method stub
		try (Connection connection = JdbcConnectionFactory.getConnection();) {
			String SQL = "UPDATE SALARIES SET salary=? where emp_no=? AND from_date=? AND to_date=?";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, salaries.getSalary());
			preparedStatement.setInt(2, salaries.getEmployeeNo());
			preparedStatement.setDate(3, new java.sql.Date(salaries.getFromDate().getTime()));
			preparedStatement.setDate(4, new java.sql.Date(salaries.getToDate().getTime()));
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
