package com.cdac.validation;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.dto.Employee;
import com.cdac.dto.Manager;

@Service
public class ManagerValidationReg implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Manager.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"managerName", "enmKey", "User name required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "managerPass", "passKey", "User Pass required");
		
		Manager manager = (Manager)target;
		if(manager.getManagerPass()!=null) {
			if(manager.getManagerPass().length()<3) { 
				errors.rejectValue("managerPass", "passKey", "PassWord Must be of 3 Characters");
			}
		}
		
	}	
}