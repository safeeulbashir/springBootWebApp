package com.safee.DAO.interfaces;

import com.safee.model.Salary;

public interface SalaryDaoInterface {
	public Salary getSalaries(int empId);
	public  void updateSalary(Salary salaries);
}
