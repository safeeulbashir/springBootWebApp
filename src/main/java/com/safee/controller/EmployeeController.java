package com.safee.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.safee.validator.EmpInfValidator;
import com.safee.validator.EmployeeValidator;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeServices employeeServices;
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	@Autowired
	private EmployeeValidator employeeValidator;
	@Autowired
	private EmpInfValidator empInfValidator;

	@InitBinder("employee")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
		logger.debug("Binder called for employee");
		binder.addValidators(employeeValidator);

	}

	@InitBinder("empInfValidator")
	public void empInfBinder(WebDataBinder binder) {
		binder.addValidators(empInfValidator);
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
		if (employeeServices == null)
			logger.debug("employee service is null");
		logger.debug("employee service is not null");
		logger.debug(employeeServices.getEmployeeById(employeeId).getFirstName());
		((Map<String, Object>) model).put("employee", employeeServices.getEmployeeById(employeeId));
		return "view";
	}

	@RequestMapping(value = "/updateEmployee")
	public String getUpdateEmployee(Model model) {
		return "update";
	}

	@RequestMapping(value = "/updateEmployee/{employeeId}")
	public String updateEmployee(@PathVariable Integer employeeId, Model model) {
		logger.debug(employeeServices.getEmployeeById(employeeId).getFirstName());
		((Map<String, Object>) model).put("employee", employeeServices.getEmployeeById(employeeId));

		return "update";
	}

	@ModelAttribute("employeeInformation")
	public EmployeeInformations getUser(Model Model) {
		return new EmployeeInformations();
	}

	@ModelAttribute("employee")
	public Employee getEmployeeForView(Model Model) {
		// employee.setEmployeeNo(employeeServices.getNewEmployeeID());
		Employee employee = new Employee();
		return employee;
	}

	@RequestMapping(value = "/updateEmployeeInformation", method = RequestMethod.POST)
	public String updateEmployeeInformation(
			@ModelAttribute("employee") Employee employee, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "updateEmployee";
		}
		 employeeServices.updateEmployee(employee);
		model.put("message", "Message From Heaven");//
		return "view";
	}

	@RequestMapping(value = "/addEmployee")
	public String addEmployeeInformation(ModelMap model) {
		return "addEmployee";
	}

	@RequestMapping(value = "/addInformation", method = RequestMethod.POST)
	public String addInformation(@ModelAttribute("employee") @Valid Employee employee, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			logger.error("Model not mapped. Error from addInformation");
			return "addEmployee";
		}
		model.put("message", "Employee added Successfully");
		employeeServices.addEmployee(employee);
		return "view";
	}

}