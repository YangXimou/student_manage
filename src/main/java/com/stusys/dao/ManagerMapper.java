package com.stusys.dao;

import com.stusys.pojo.Manager;
import com.stusys.pojo.Student;

public interface ManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);

    Manager selectByManagerId(Integer managerId);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    String getPassword(Integer managerId);
}