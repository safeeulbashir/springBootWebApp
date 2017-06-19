package com.safee.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.safee.model.Employee;
import com.safee.model.EmployeeInformations;

@Component
public class EmpInfValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (clazz.equals(EmployeeInformations.class)) {
			return true;
		}
		return false;

	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

	}

}
