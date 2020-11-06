package com.cdac.validation;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.dto.Employee;

@Service
public class UserValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeName", "enmKey", "User name required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeePass", "passKey", "User Pass required");
		
		Employee employee = (Employee)target;
		if(employee.getEmployeePass()!=null) {
			if(employee.getEmployeePass().length()<3) { 
				errors.rejectValue("employeePass", "passKey", "PassWord Must be of 8 Characters");
			}
		}
		
	}	
}