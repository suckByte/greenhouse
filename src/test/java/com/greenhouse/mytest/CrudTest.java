package com.greenhouse.mytest;

import java.util.UUID;

import org.apache.commons.io.IOCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.greenhouse.dao.IDepartmentDao;
import com.greenhouse.dao.IEmployeeDao;
import com.greenhouse.pojo.Department;
import com.greenhouse.pojo.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class CrudTest {

	//1.创建springioc容器
	//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
	//2.从容器中获取mapper
	//IDepartmentDao iDepartmentDao = applicationContext.getBean(IDepartmentDao.class);
	
	private static Logger logger = Logger.getLogger(CrudTest.class);
	
	@Autowired
	private IDepartmentDao iDepartmentDao;
	
	@Autowired
	private IEmployeeDao iEmployeeDao;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testInsert() {
//		System.out.println(iDepartmentDao);
//		iDepartmentDao.insertSelective(new Department(null, "Sales & Marketing"));
//		iDepartmentDao.insertSelective(new Department(null, "Finance"));
//		
//		iEmployeeDao = sqlSession.getMapper(IEmployeeDao.class);
//		for (int i = 0; i < 1000; i++) {
//			String uuid = UUID.randomUUID().toString().substring(0, 5) + i;
//			iEmployeeDao.insertSelective(new Employee(null, uuid, "F", uuid + "@greenhouse.com", 1));
//		}
//		System.out.println("FINISHED");
		Employee e1 = iEmployeeDao.selectByPrimaryKey(21);
		logger.info(JSON.toJSONString(e1));
	}
	
}
