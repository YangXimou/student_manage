package com.stusys.dao;

import com.stusys.dto.StudentCourseDetailDto;
import com.stusys.pojo.ChildCourse;
import com.stusys.pojo.Student;
import com.stusys.pojo.StudentCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    StudentCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);

    List<ChildCourse> selectChildCourseBase(Integer studentId);

    StudentCourseDetailDto selectDetailPlus(@Param("studentId") Integer studentId, @Param("childCourseId") Integer childCourseId);

    List<Student> getStudentsBase(Integer childCourseId);

    int updateSelective(StudentCourse record);
}