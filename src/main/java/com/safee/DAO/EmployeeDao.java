package com.safee.DAO;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.safee.DAO.interfaces.EmployeeDaoInterface;
import com.safee.model.Employee;

@Repository
@Transactional
public class EmployeeDao implements EmployeeDaoInterface {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDao.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		String hql = "FROM Employee as e ORDER BY p.first_name";
		return (List<Employee>) hibernateTemplate.find(hql);
	}

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		logger.debug(employee.getFirstName());
		hibernateTemplate.save(employee);
		// hibernateTemplate.save(employee);
	}

	@Override
	public Employee getEmployee(Integer employeeNo) {
		logger.debug("Employee ID: " + employeeNo);
		if (hibernateTemplate == null)
			logger.debug("template is null");

		return hibernateTemplate.get(Employee.class, employeeNo);

	}

	@Override
	public void updateEmployee(Employee employee) {

		// TODO Auto-generated method stub
		/*
		 * try (Connection connection = JdbcConnectionFactory.getConnection();)
		 * { String SQL =
		 * "UPDATE employees SET first_name=?, last_name=?, birth_date=?, hire_date=? where emp_no=?"
		 * ; PreparedStatement preparedStatement =
		 * connection.prepareStatement(SQL); preparedStatement.setString(1,
		 * employee.getFirstName()); preparedStatement.setString(2,
		 * employee.getLastName()); preparedStatement.setDate(3, new
		 * java.sql.Date(employee.getBirthDate().getTime()));
		 * preparedStatement.setDate(4, new
		 * java.sql.Date(employee.getHireDate().getTime()));
		 * preparedStatement.setLong(5, employee.getEmployeeNo());
		 * logger.debug(preparedStatement.toString());
		 * preparedStatement.executeUpdate();
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */ }

}
