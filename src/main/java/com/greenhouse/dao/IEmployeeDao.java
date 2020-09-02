package com.greenhouse.dao;

import com.greenhouse.pojo.Employee;

public interface IEmployeeDao {
    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer empId);
    
    Employee selectByPrimaryKeyWithDept(Integer empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}