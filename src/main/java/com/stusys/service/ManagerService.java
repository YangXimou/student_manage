package com.stusys.service;

import com.stusys.dto.ClassDto;
import com.stusys.dto.MajorDto;
import com.stusys.pojo.*;
import com.stusys.pojo.Class;
import com.stusys.vo.ResultVO;

import java.util.List;

/**
 * Created by Simon on 2018/12/3.
 */
public interface ManagerService {
    public Manager getManagerInfo(Integer managerId);
    public List<Student> getStudentList(Integer pageNum, Integer pageSize);
    public List<Teacher> getTeacherList(Integer pageNum, Integer pageSize);
    public List<Student> searchStudent(String key);
    public List<Teacher> searchTeacher(String key);
    public List<Department> getDepartmentList(Integer pageNum, Integer pageSize);
    public List<Major> getMajorList(Integer pageNum,Integer pageSize);
    public List<ClassDto> getClassList(Integer pageNum, Integer pageSize);

    public Department getDepartmentInfo(Integer departmentId);
    public MajorDto getMajorInfo(Integer majorId);
    public ClassDto getClassInfo(Integer classId);

    public Integer updateDepartment(Integer departmentId,String name,String introductions);
    public Integer updateMajor(Integer majorId,Integer departmentId,String name,String introductions);
    public Integer insertDepartment(Integer departmentId,String name,String introductions);
    public Integer insertMajor(Integer majorId,Integer departmentId,String name,String introductions);
    public Integer updateClass(Integer classId,Integer majorId,Integer departmentId,String name,Integer grade);

}
