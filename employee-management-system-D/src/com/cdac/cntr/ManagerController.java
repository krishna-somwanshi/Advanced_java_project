package com.cdac.cntr;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.dto.Employee;
import com.cdac.dto.Manager;
import com.cdac.service.ManagerService;
import com.cdac.validation.ManagerValidation;
import com.cdac.validation.ManagerValidationReg;

@Controller
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private ManagerValidation managerValidation;
	
	@Autowired
	private ManagerValidationReg managerValidationReg;
	
	@RequestMapping(value = "/prep_reg_form_man.htm", method = RequestMethod.GET)
	public String prepRegForm(Manager manager, ModelMap map,HttpSession session) {
		map.put("manager", new Manager());
		return "reg1_form";
	}
	
	@RequestMapping(value = "/reg1.htm", method = RequestMethod.POST)
	public String register(Manager manager, BindingResult result, ModelMap map,HttpSession session) {
		managerValidationReg.validate(manager, result);
		if(result.hasErrors()) {
			return "reg1_form";
		}
		managerService.addManager(manager);
		return "index";
	}
	
	@RequestMapping(value = "/prep_log_form_man.htm", method = RequestMethod.GET)
	public String prepLogFormMan(ModelMap map) {
		map.put("manager", new Manager());
		return "login1_form";
	}
	
	@RequestMapping(value = "/login1.htm", method = RequestMethod.POST)
	public String login1(Manager manager,BindingResult result, ModelMap map,HttpSession session) {
		
		managerValidation.validate(manager, result);
		if(result.hasErrors()) {
			return "login1_form";
		}
		
		boolean b = managerService.findManager(manager);
		if(b) {
			session.setAttribute("manager", manager);
			return "man_home";
		}else {
			map.put("manager", new Manager());
			return "login1_form";
		}
	}	
	
}
//@RequestMapping(value ="/assign_task_form", method = RequestMethod.GET)
//public String prepRegFormMan(ModelMap map) {
//	map.put("manager", new Manager());
//	return "reg1_form";
//}
//
//@RequestMapping(value = "/reg1.htm", method = RequestMethod.POST)
//public String register1(Manager manager, ModelMap map) {
//	managerService.addManager(manager);
//	return "index";
//}