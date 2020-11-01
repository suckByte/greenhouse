package com.greenhouse.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greenhouse.pojo.Department;
import com.greenhouse.service.IDepartmentService;
import com.greenhouse.test.Message;

@Controller
public class DepartmentController {

	@Resource
	private IDepartmentService iDepartmentService;
	
	@RequestMapping("/getDeptName")
	@ResponseBody
	public Message getDeptName(Model model) {
		List<Department> dpList = iDepartmentService.getDeptName();
		model.addAttribute("deptName", dpList);
		return Message.Success().add("dpList", dpList);
	}
}
