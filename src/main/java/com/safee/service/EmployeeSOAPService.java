package com.safee.service;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safee.DAO.interfaces.EmployeeDaoInterface;
@Service
public class EmployeeSOAPService {
	@Autowired
	EmployeeDaoInterface employeeDaoInterface;

	public com.safee.response.Employee getEmployee(Integer employeeNo) {
		com.safee.model.Employee employee = employeeDaoInterface.getEmployee(employeeNo);
		GregorianCalendar birthDate = new GregorianCalendar();
		birthDate.setTime(employee.getBirthDate());
		XMLGregorianCalendar date = null;
		try {
			date = DatatypeFactory.newInstance().newXMLGregorianCalendar(birthDate);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		com.safee.response.Employee responseEmployee = new com.safee.response.Employee();
		responseEmployee.setFirstName(employee.getFirstName());
		responseEmployee.setLastName(employee.getLastName());
		responseEmployee.setDob(date);
		responseEmployee.setSalary(employee.getSalary().getSalary());
		return responseEmployee;
	}

}
