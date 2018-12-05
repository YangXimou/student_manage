package com.stusys.dao;

import com.stusys.pojo.Department;
import com.stusys.pojo.Major;
import com.stusys.pojo.Student;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    String selectName(Integer departmentId);

    List<Department> selectAll();

    Department selectByDepartmentId(Integer departmentId);

    int updateByDepartmentIdSelective(Department record);
}