package com.safee.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safee.DAO.interfaces.EmployeeDaoInterface;
import com.safee.model.Employee;

@Repository
@Transactional
public class EmployeeDao implements EmployeeDaoInterface {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDao.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		logger.debug(employee.getFirstName());
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		// hibernateTemplate.save(employee);
	}

	@Override
	public Employee getEmployee(Integer employeeNo) {
		/*
		 * logger.debug("Employee ID: " + employeeNo); if (hibernateTemplate ==
		 * null) logger.debug("template is null");
		 * 
		 * return hibernateTemplate.get(Employee.class, employeeNo);
		 */return null;
	}

	@Override
	public void updateEmployee(Employee employee) {

	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
