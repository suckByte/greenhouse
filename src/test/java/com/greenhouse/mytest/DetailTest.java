package com.greenhouse.mytest;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.greenhouse.pojo.Department;
import com.greenhouse.pojo.Employee;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml"})
public class DetailTest {
	
	Logger logger = Logger.getLogger(DetailTest.class);
	
	//模拟mvc请求
	private MockMvc mockmvc;
	
	//自动注入SPRINGMVC IOC容器内的内容，还需要注入容器本身@WebAppConfiguration
	@Autowired
	WebApplicationContext context;
	
	//每次引用都需要初始化mockmvc
	@Before
	public void initMock() {
		mockmvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		//模拟请求获取返回值
		MvcResult result = mockmvc.perform(MockMvcRequestBuilders.get("/detail").param("pageNum", "5")).andReturn();
		//获取到result里面包含pageInfo信息  通过request将其转化成pageInfo类型
		MockHttpServletRequest request = result.getRequest();
		PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
		System.out.println("Total page: " + pageInfo.getPages());
		System.out.println("Total nums: " + pageInfo.getTotal());
		int[] navigatepageNums = pageInfo.getNavigatepageNums();
		for (int i : navigatepageNums) {
			System.out.print(i + " ");
		}
		System.out.println();
		List<Employee> employees = pageInfo.getList();
		for (Employee employee : employees) {
			System.out.println("ID: " + employee.getEmpId() + " Name: " + employee.getEmpName() + " Email: " + employee.getEmail());
		}
	}
	
	@Test
	public void testDept() throws Exception {
		MvcResult result = mockmvc.perform(MockMvcRequestBuilders.get("/getDeptName")).andReturn();
		MockHttpServletRequest request = result.getRequest();
		List<Department> dpList = (List<Department>) request.getAttribute("deptName");
		
//		测试前注释掉DepartmentController的@ResponseBody,否则返回的是空值null
		for (Department department : dpList) {
			System.out.println("DID: " + department.getDeptId() + " " + "DeptName: " + department.getDeptName());
		}
	}
}
