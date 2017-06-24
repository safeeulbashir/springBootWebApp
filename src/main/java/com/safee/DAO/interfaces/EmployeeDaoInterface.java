package com.safee.DAO.interfaces;

import java.util.List;

import com.safee.model.Employee;

public interface EmployeeDaoInterface {
	Employee getEmployee(Integer employeeNo);
	void updateEmployee(Employee employee);
	void addEmployee(Employee employee);
	public List<Employee> getAllEmployee();

}
