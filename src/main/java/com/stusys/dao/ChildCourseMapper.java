package com.stusys.dao;

import com.stusys.pojo.ChildCourse;

public interface ChildCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChildCourse record);

    int insertSelective(ChildCourse record);

    ChildCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChildCourse record);

    int updateByPrimaryKey(ChildCourse record);
}