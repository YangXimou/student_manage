package com.stusys.dao;

import com.stusys.dto.TeacherBaseDto;
import com.stusys.pojo.ChildCourse;
import com.stusys.pojo.TeacherCourse;

import java.util.List;

public interface TeacherCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherCourse record);

    int insertSelective(TeacherCourse record);

    TeacherCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherCourse record);

    int updateByPrimaryKey(TeacherCourse record);

    TeacherBaseDto selectTeacherBase(Integer childCourseId);

    List<ChildCourse> selectChildCourseBase(Integer teacherId);
}