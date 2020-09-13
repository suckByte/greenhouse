package com.greenhouse.dao;

import java.util.List;

import com.greenhouse.pojo.Employee;

public interface IEmployeeDao {
    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer empId);
    
    Employee selectByPrimaryKeyWithDept(Integer empId);
    
    List<Employee> selectByExampleWithDept();

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}