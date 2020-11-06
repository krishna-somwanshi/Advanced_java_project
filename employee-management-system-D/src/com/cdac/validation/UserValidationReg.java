package com.cdac.validation;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.dto.Employee;

@Service
public class UserValidationReg implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeName", "nameKey", "User name required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeEmail", "emailKey", "User Email required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeePass", "passKey", "User Pass required");
		
		Employee employee = (Employee)target;
		if(employee.getEmployeeName()==null) { 
				errors.rejectValue("employeeName", "nameKey1", "Name Must be filled");
		}
		else if(employee.getEmployeeEmail()==null) { 
			errors.rejectValue("employeeEmail", "emailKey1", "Email Must be filled");
		}else if(employee.getEmployeePass()==null) { 
			errors.rejectValue("employeePass", "passKey1", "PassWord Must be filled");
		}
	}	
}