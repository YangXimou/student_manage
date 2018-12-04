package com.stusys.dao;

import com.stusys.pojo.Manager;
import com.stusys.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    Teacher selectByTeacherId(Integer teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    String getPassword(Integer teacherId);

}