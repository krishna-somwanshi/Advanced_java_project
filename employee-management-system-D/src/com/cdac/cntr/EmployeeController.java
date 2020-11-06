package com.cdac.cntr;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.dto.Employee;
import com.cdac.dto.Management;
import com.cdac.service.EmployeeService;
import com.cdac.validation.UserValidation;
import com.cdac.validation.UserValidationReg;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private UserValidation userValidation;
	@Autowired
	private UserValidationReg userValidationReg;
	
	@RequestMapping(value = "/prep_reg_form.htm", method = RequestMethod.GET)
	public String prepRegForm(ModelMap map) {
		map.put("employee", new Employee());
		return "reg_form";
	}
	
	@RequestMapping(value = "/reg.htm", method = RequestMethod.POST)
	public String register(Employee employee,BindingResult result, ModelMap map) {
		userValidationReg.validate(employee, result);
		if(result.hasErrors()) {
			return "reg_form";
		}
		employeeService.addEmployee(employee);
		return "index";
	}
	
	@RequestMapping(value = "/prep_log_form.htm", method = RequestMethod.GET)
	public String prepLogForm(ModelMap map) {
		map.put("employee", new Employee());
		return "login_form";
	}
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public String login(Employee employee,BindingResult result ,ModelMap map, HttpSession session) {
		
		userValidation.validate(employee, result);
		if(result.hasErrors()) {
			return "login_form";
		}
		
		boolean b = employeeService.findEmployee(employee);
		if(b) {
			session.setAttribute("employee", employee);
			return "home";
		}else {
			map.put("employee", new Employee());
			return "login_form";
		}
	}
}