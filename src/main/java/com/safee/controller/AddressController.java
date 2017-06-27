package com.safee.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class AddressController {
	@RequestMapping(value = "/addAddress/{employeeId}")
	public String getEmployee(Model model) {
		// model.put("message", this.message);
		return "addAddress";
	}


}
