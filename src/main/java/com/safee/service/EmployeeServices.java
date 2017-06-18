package com.safee.service;

import org.springframework.stereotype.Service;

import com.safee.DAO.DepartmentDao;
import com.safee.DAO.EmployeeDao;
import com.safee.DAO.SalariesDao;
import com.safee.model.Employee;
import com.safee.model.EmployeeInformations;
import com.safee.model.Salaries;
@Service
public class EmployeeServices {

	private DepartmentDao departmentDao = new DepartmentDao();
	private EmployeeDao employeeDao = new EmployeeDao();
	private SalariesDao salariesDao = new SalariesDao();

	public EmployeeInformations getEmployeeInformation(int empID) {

		EmployeeInformations employeeInformations = new EmployeeInformations();
		employeeInformations.setFirstName(employeeDao.getEmployee(empID).getFirstName());
		;
		employeeInformations.setLastName(employeeDao.getEmployee(empID).getLastName());
		employeeInformations.setEmpNo(employeeDao.getEmployee(empID).getEmployeeNo());
		employeeInformations.setJoinDate(employeeDao.getEmployee(empID).getHireDate());

		try {
			String deptName = departmentDao.getDepartment(empID).getDepName();
			employeeInformations.setDeptartmentName(deptName);
		} catch (NullPointerException nullPointerException) {
			employeeInformations.setDeptartmentName("N/A");
		}
		try {
			Integer salary = salariesDao.getSalaries(empID).getSalary();
			employeeInformations.setSalary(salary);
		} catch (NullPointerException nullPointerException) {
			// TODO: handle exception
			employeeInformations.setSalary(65000);
		}
		return employeeInformations;
	}

	public void updateEmployee(EmployeeInformations employeeInformations) {

		// TODO Auto-generated method stub

		Employee employee = employeeDao.getEmployee(employeeInformations.getEmpNo());
		employee.setFirstName(employeeInformations.getFirstName());
		employee.setLastName(employeeInformations.getLastName());
		employeeDao.updateEmployee(employee);
		try{
			Salaries salaries = salariesDao.getSalaries(employeeInformations.getEmpNo());
			salaries.setSalary(employeeInformations.getSalary());
			salariesDao.updateSalary(salaries);	
		}catch (NullPointerException nullPointerException) {
			// TODO: handle exception
			System.out.println("Null Pointer Exception Occured.");
		}
		
	}

	public Integer getNewEmployeeID() {
		// TODO Auto-generated method stub

		return employeeDao.getNewEmployeeID();
	}

	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Added");
		employeeDao.addEmployee(employee);
	}

}
