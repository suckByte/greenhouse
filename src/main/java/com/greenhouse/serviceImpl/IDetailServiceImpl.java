package com.greenhouse.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.greenhouse.dao.IEmployeeDao;
import com.greenhouse.pojo.Employee;
import com.greenhouse.service.IDetailService;

@Service("detailService")
public class IDetailServiceImpl implements IDetailService {
	
	@Resource
	private IEmployeeDao iEmployeeDao;
	
	@Override
	public List<Employee> getDetail() {
		// TODO Auto-generated method stub
		return iEmployeeDao.selectByExampleWithDept();
	}

	@Override
	public void addDetail(Employee employee) {
		// TODO Auto-generated method stub
		iEmployeeDao.insertSelective(employee);
	}

}
