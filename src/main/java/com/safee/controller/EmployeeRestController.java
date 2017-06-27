package com.safee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.safee.service.EmployeeRestServices;
import com.safee.service.EmployeesAllInformation;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeRestServices employeeRestServices;

	@RequestMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)

	public EmployeesAllInformation viewEmployee(@PathVariable Integer employeeId) {
		EmployeesAllInformation employeesAllInformation = employeeRestServices.getEmployeeById(employeeId);
		return employeesAllInformation;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addInformation(@RequestBody EmployeesAllInformation employeesAllInformation) {
		
		//model.put("message", "Employee added Successfully");
		logger.debug("Employee Salary " + employeesAllInformation.getFirstName());
		employeeRestServices.addEmployee(employeesAllInformation);
		return "Employee Added";
	}

}