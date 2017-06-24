package com.safee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safee.DAO.EmployeeDao;
import com.safee.DAO.interfaces.EmployeeDaoInterface;
import com.safee.model.Employee;
@Service
public class EmployeeServices {
	@Autowired
	EmployeeDaoInterface employeeDaoInterface;
	public Employee getEmployeeById(Long employeeNo)
	{
		return employeeDaoInterface.getEmployee(employeeNo);
	}
	public void getAllEmployeeById()
	{
		employeeDaoInterface.getAllEmployee();
	}
	public void addEmployee(Employee employee)
	{
		employeeDaoInterface.addEmployee(employee);
	}
}
