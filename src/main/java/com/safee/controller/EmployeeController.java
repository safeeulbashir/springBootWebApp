package com.safee.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.safee.DAO.EmployeeDao;
import com.safee.model.Employee;
import com.safee.model.EmployeeInformations;
import com.safee.service.EmployeeServices;

@Controller
public class EmployeeController {

	EmployeeServices employeeServices = new EmployeeServices();
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "index";
	}

	@RequestMapping(value = "/viewEmployee")
	public String getEmployee(Model model) {
		// model.put("message", this.message);
		return "view";
	}

	@RequestMapping(value = "/viewEmployee/{employeeId}")
	public String view(@PathVariable Integer employeeId, Model model) {
		EmployeeInformations employeeInformations = employeeServices.getEmployeeInformation(employeeId);
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.getEmployee(employeeId);
		((Map<String, Object>) model).put("employeeInformation", employeeInformations);
		return "view";
	}

	@RequestMapping(value = "/updateEmployee")
	public String getUpdateEmployee(Model model) {
		// model.put("message", this.message);
		return "update";
	}

	@RequestMapping(value = "/updateEmployee/{employeeId}")
	public String updateEmployee(@PathVariable Integer employeeId, Model model) {
		EmployeeInformations employeeInformations = employeeServices.getEmployeeInformation(employeeId);
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.getEmployee(employeeId);
		((Map<String, Object>) model).put("employeeInformation", employeeInformations);
		return "update";
	}

	@ModelAttribute("employeeInformation")
	public EmployeeInformations getUser(Model Model) {
		return new EmployeeInformations();
	}

	@ModelAttribute("employee")
	public Employee getEmployeeForView(Model Model) {
		Employee employee = new Employee();
		employee.setEmployeeNo(employeeServices.getNewEmployeeID());
		return employee;
	}

	@RequestMapping(value = "/updateEmployeeInformation", method = RequestMethod.POST)
	public String updateEmployeeInformation(
			@Valid @ModelAttribute("employeeInformation") EmployeeInformations employeeInformation,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "view";
		}
		employeeServices.updateEmployee(employeeInformation);
		model.put("message", "Employee Updated Successfully");//
		return "view";
	}

	@RequestMapping(value = "/addEmployee")
	public String addEmployeeInformation(ModelMap model) {

		model.put("employeeNo", employeeServices.getNewEmployeeID());
		return "addEmployee";
		/*
		 * employeeServices.updateEmployee(employeeInformation);
		 * model.put("message", "Employee Updated Successfully");//
		 */
	}

	@RequestMapping(value = "/addInformation", method = RequestMethod.POST)
	public String addInformation(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {

		}
		model.put("message", "Employee added Successfully");
		employeeServices.addEmployee(employee);
		return "view";
	}

}