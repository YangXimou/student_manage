package com.stusys.dao;

import com.stusys.dto.CourseDto;
import com.stusys.pojo.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    CourseDto selectCourseDto(Integer courseId);
}