package com.greenhouse.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.greenhouse.dao.IDepartmentDao;
import com.greenhouse.pojo.Department;
import com.greenhouse.service.IDepartmentService;

@Service("departmentService")
public class IDepartmentServiceImpl implements IDepartmentService {

	@Resource
	private IDepartmentDao iDepartmentDao;
	
	@Override
	public List<Department> getDeptName() {
		// TODO Auto-generated method stub
		return iDepartmentDao.selectAllDeptName();
	}

}
