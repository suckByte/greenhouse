package com.greenhouse.dao;

import java.util.List;

import com.greenhouse.pojo.Department;

public interface IDepartmentDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    List<Department> selectAllDeptName();
}