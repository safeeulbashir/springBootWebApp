package com.safee.controller;

import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safee.model.EmployeeInformations;
import com.safee.service.EmployeeServices;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	EmployeeServices employeeServices = new EmployeeServices();

	@RequestMapping("/{employeeId}")
		public EmployeeInformations viewEmployee(@PathVariable Integer employeeId) {
		//return new Greeting(counter.incrementAndGet(), String.format(template, name));
		EmployeeInformations employeeInformations = employeeServices.getEmployeeInformation(employeeId);
		return employeeInformations;
	}
	
	

}
