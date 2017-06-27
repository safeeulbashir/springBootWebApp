package com.safee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.safee.response.GetEmployeeRequest;
import com.safee.response.GetEmployeeResponse;
import com.safee.service.EmployeeSOAPService;

@Endpoint
public class EmployeeSOAPController {
	private static final String NAMESPACE_URI = "http://www.safee.com/response";
	@Autowired
	EmployeeSOAPService employeeSOAPService;
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getCountry(@RequestPayload GetEmployeeRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		//response.setCountry(countryRepository.findCountry(request.getName()));
		response.setEmployee(employeeSOAPService.getEmployee(request.getEmployeeId()));
		return response;
	}

}
