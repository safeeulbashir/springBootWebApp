package com.safee.DAO.interfaces;

import com.safee.model.Salaries;

public interface SalaryDaoInterface {
	public Salaries getSalaries(int empId);
	public  void updateSalary(Salaries salaries);
}
