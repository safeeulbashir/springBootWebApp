package com.safee.service;

import com.safee.model.Department;
import com.safee.model.Employee;
import com.safee.model.Salary;

public class EmployeesAllInformation {

	private Employee employee;
	private Department department;
	private Salary salaries;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Salary getSalaries() {
		return salaries;
	}

	public void setSalaries(Salary salaries) {
		this.salaries = salaries;
	}
}
