package com.safee.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.safee.model.Employee;
@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		if (clazz.equals(Employee.class)) {
			return true;
		}

		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Employee user = (Employee) target;
		ValidationUtils.rejectIfEmpty(errors, "firstName", "user.username.empty.err");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "user.username.empty.err");
		//errors.rejectValue("firstName", "Tada");
	}

}
