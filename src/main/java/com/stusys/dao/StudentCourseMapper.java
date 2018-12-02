package com.stusys.dao;

import com.stusys.pojo.Student;
import com.stusys.pojo.StudentCourse;

import java.util.List;

public interface StudentCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    StudentCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);
}