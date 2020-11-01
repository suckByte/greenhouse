package com.greenhouse.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.greenhouse.pojo.Employee;
import com.greenhouse.service.IDetailService;
import com.greenhouse.test.Message;

/**
 * 	查询所有员工的信息
 * @author Westin IT
 *
 */
@Controller
public class EmployeeController {
	
	@Resource
	private IDetailService iDetailService;
	
	/**
	 * Use jackson plugin to get JSON data
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/detail")
	@ResponseBody
	public Message getDetailWithJson(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum) {
		//使用pagehelper分页插件
		PageHelper.startPage(pageNum, 5);
		//紧跟分页查询
		List<Employee> detailList = iDetailService.getDetail();
		//使用pageInfo封装分页信息和查询的数据
		PageInfo<Employee> pageInfo = new PageInfo<>(detailList, 5);
		
		return Message.Success().add("pageInfo", pageInfo);
	}
	
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	@ResponseBody
	public Message addEmployee(Employee employee) {
		iDetailService.addDetail(employee);
		return Message.Success();
	}
	
	//@RequestMapping("/detail")
	public String getEmployee(@RequestParam(value = "pageNum", defaultValue = "5") Integer pageNum, Model model) {
		//使用PageHelper分页插件
		PageHelper.startPage(pageNum, 6);
		//紧跟着分页查询
		List<Employee> detailList = iDetailService.getDetail();
		//使用pageInfo进行包装，封装了查询的信息和分页的信息
		PageInfo<Employee> pageInfo = new PageInfo<>(detailList, 5);
		//将pageInfo通过Model传到页面
		model.addAttribute("pageInfo", pageInfo);
		
		return "empList";
	}
	
}
