package com.cdac.cntr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.Employee;
import com.cdac.dto.Management;
import com.cdac.dto.Manager;
import com.cdac.service.ManagementService;

@Controller
public class ManagementController {
	
	@Autowired
	private ManagementService managementService;
	
	@RequestMapping(value = "/assign_task_form.htm",method = RequestMethod.GET)
	public String prepManagementAddForm(ModelMap map) {
		map.put("management", new Management());
		return "assign_task";	
	}
	
	@RequestMapping(value = "task_add.htm",method = RequestMethod.POST)
	public String managementAdd(Management management,HttpSession session) {
		int managerId = ((Manager)session.getAttribute("manager")).getManagerId();
		management.setManagerId(managerId);
		managementService.addinfo(management);
		return "man_home";
	}
	
	
	@RequestMapping(value = "/task_list_form.htm", method = RequestMethod.GET)
	public String allTasks(ModelMap map,HttpSession session) {
		int managerId = ((Manager)session.getAttribute("manager")).getManagerId();
		List<Management> li = managementService.selectAllman(managerId);
		map.put("tList", li);
		return "task_list";	
	}
	
	@RequestMapping(value = "/task_delete.htm", method = RequestMethod.GET)
	public String taskDelete(@RequestParam int manid,ModelMap map,HttpSession session) {
		managementService.removeinfo(manid);
		int managerId = ((Manager)session.getAttribute("manager")).getManagerId();
		List<Management> li = managementService.selectAllman(managerId);
		map.put("tList", li);
		return "task_list";	
	}
	
	@RequestMapping(value = "/task_update_form.htm", method = RequestMethod.GET)
	public String taskUpdateForm(@RequestParam int manid,ModelMap map) {
		Management man = managementService.selectinfo(manid);
		map.put("management", man);
		return "task_update";	
	}

	@RequestMapping(value = "/task_update.htm",method = RequestMethod.POST)
	public String taskUpdate(Management management,ModelMap map,HttpSession session) {
		
		int managerId = ((Manager)session.getAttribute("manager")).getManagerId();
		management.setManagerId(managerId);
		managementService.modifyinfo(management);
		List<Management> li = managementService.selectAllman(managerId);
		map.put("tList", li);
		return "task_list";
		
	}
	
	@RequestMapping(value = "/task_form.htm", method = RequestMethod.GET)
	public String empTask(ModelMap map,HttpSession session) {
		int employeeId = ((Employee)session.getAttribute("employee")).getEmployeeId();
		List<Management> li = managementService.selectAll(employeeId);
		map.put("tList", li);
		return "emp_task_list";	
	}
}
