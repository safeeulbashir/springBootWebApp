package com.safee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safee.DAO.interfaces.EmployeeDaoInterface;
import com.safee.model.Employee;
import com.safee.model.Salary;

@Service
public class EmployeeRestServices {
	@Autowired
	EmployeeDaoInterface employeeDaoInterface;

	public EmployeesAllInformation getEmployeeById(Integer employeeNo) {
		Employee employee = employeeDaoInterface.getEmployee(employeeNo);
		EmployeesAllInformation employeesAllInformation = new EmployeesAllInformation();
		employeesAllInformation.setBirthDate(employee.getBirthDate());
		employeesAllInformation.setHireDate(employee.getHireDate());
		employeesAllInformation.setEmployeeNo(employee.getEmployeeNo());
		employeesAllInformation.setFirstName(employee.getFirstName());
		employeesAllInformation.setLastName(employee.getLastName());
		employeesAllInformation.setGender(employee.getGender());
		employeesAllInformation.setSalary(employee.getSalary().getSalary());
		List<Address> addresses = new ArrayList<>();
		for (int i = 0; i < employee.getAddresses().size(); ++i) {

			addresses.add(new Address(employee.getAddresses().get(i).getLine1(),
					employee.getAddresses().get(i).getLine2(), employee.getAddresses().get(i).getCity(),
					employee.getAddresses().get(i).getState(), employee.getAddresses().get(i).getZip()));
		}
		employeesAllInformation.setAddresses(addresses);
		return employeesAllInformation;
	}

	public void getAllEmployeeById() {
		employeeDaoInterface.getAllEmployee();
	}

	public void addEmployee(EmployeesAllInformation employeesAllInformation) {
		Employee employee = new Employee(employeesAllInformation.getBirthDate(), employeesAllInformation.getHireDate(),
				employeesAllInformation.getFirstName(), employeesAllInformation.getLastName(),
				employeesAllInformation.getGender());
		Salary salary = new Salary(employeesAllInformation.getSalary());
		salary.setEmployee(employee);
		employee.setSalary(salary);
		List<com.safee.model.Address> addresses = new ArrayList<>();
		for (int i = 0; i < employeesAllInformation.getAddresses().size(); ++i) {
			com.safee.model.Address address = new com.safee.model.Address(
					employeesAllInformation.getAddresses().get(i).getLine1(),
					employeesAllInformation.getAddresses().get(i).getLine2(),
					employeesAllInformation.getAddresses().get(i).getCity(),
					employeesAllInformation.getAddresses().get(i).getState(),
					employeesAllInformation.getAddresses().get(i).getZip());
			address.setEmployee(employee);
		}
		employee.setAddresses(addresses);
		 employeeDaoInterface.addEmployee(employee);
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoInterface.updateEmployee(employee);

	}
}
