package com.stusys.dao;

import com.stusys.dto.StudentDto;
import com.stusys.pojo.Student;
import org.apache.ibatis.annotations.Param;

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

    Student selectBaseByStudentId(Integer studentId);

    StudentDto getBasePlusByStudentId(Integer studentId);

    List<Student> selectAllBase();

    List<Student> fuzzySearch(@Param("key") String key);

    Integer getNewestStudentId(Integer classId);
}