package com.stusys.dao;

import com.stusys.dto.ChildCourseDto;
import com.stusys.pojo.ChildCourse;
import com.stusys.pojo.Student;

import java.util.List;

public interface ChildCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChildCourse record);

    int insertSelective(ChildCourse record);

    ChildCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChildCourse record);

    int updateByPrimaryKey(ChildCourse record);

    ChildCourse selectByChildCourseId(Integer childCourseId);

    ChildCourseDto selectDetailPlus(Integer childCourseId);

}