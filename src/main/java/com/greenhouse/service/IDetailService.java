package com.greenhouse.service;

import java.util.List;

import com.greenhouse.pojo.Employee;

public interface IDetailService {

	public List<Employee> getDetail();
	
	public void addDetail(Employee employee);
}
