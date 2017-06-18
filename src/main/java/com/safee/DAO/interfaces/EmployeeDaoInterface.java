package com.safee.DAO.interfaces;

import com.safee.model.Employee;

public interface EmployeeDaoInterface {
	Employee getEmployee(int empId);
	void updateEmployee(Employee employee);
	Integer getNewEmployeeID();
	void addEmployee(Employee employee);

}
