package com.stusys.dao;

import com.stusys.dto.StudentDto;
import com.stusys.pojo.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    StudentDto selectDetailByStudentId(Integer studentId);

    int updateByStudentIdSelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectAll();

    String getPassword(Integer studentId);
}