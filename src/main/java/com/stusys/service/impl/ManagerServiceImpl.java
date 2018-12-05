package com.stusys.service.impl;

import com.github.pagehelper.PageHelper;
import com.stusys.dao.*;
import com.stusys.dto.ClassDto;
import com.stusys.dto.MajorDto;
import com.stusys.pojo.*;
import com.stusys.pojo.Class;
import com.stusys.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Simon on 2018/12/3.
 */

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    public Manager getManagerInfo(Integer managerId){
        return managerMapper.selectByManagerId(managerId);
    }


    public List<Student> getStudentList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return studentMapper.selectAllBase();
    }
    public List<Teacher> getTeacherList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return teacherMapper.selectAllBase();
    }
    public List<Department> getDepartmentList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return departmentMapper.selectAll();
    }
    public List<Major> getMajorList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return majorMapper.selectAllBase();
    }
    public List<ClassDto> getClassList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return classMapper.selectAllBasePlus();
    }



    public List<Student> searchStudent(String key){
        return studentMapper.fuzzySearch(key);
    }
    public List<Teacher> searchTeacher(String key){
        return teacherMapper.fuzzySearch(key);
    }
    public Department getDepartmentInfo(Integer departmentId){
        return departmentMapper.selectByDepartmentId(departmentId);
    }
    public MajorDto getMajorInfo(Integer majorId){
        return majorMapper.selectByMajorId(majorId);
    }
    public ClassDto getClassInfo(Integer classId){
        return classMapper.selectDetailPlusByClassId(classId);
    }





    public Integer updateDepartment(Integer departmentId,String name,String introductions){
        Department department=new Department();
        department.setDepartmentId(departmentId);
        department.setName(name);
        department.setIntroductions(introductions);
        return departmentMapper.updateByDepartmentIdSelective(department);
    }
    public Integer updateMajor(Integer majorId,Integer departmentId,String name,String introductions){
        Major major=new Major();
        major.setMajorId(majorId);
        major.setDepartmentId(departmentId);
        major.setName(name);
        major.setIntroductions(introductions);
        return majorMapper.updateByMajorIdSelective(major);
    }
    public Integer updateClass(Integer classId,Integer majorId,Integer departmentId,String name,Integer grade){
        Class newClass=new Class();
        newClass.setClassId(classId);
        newClass.setMajorId(majorId);
        newClass.setDepartmentId(departmentId);
        newClass.setName(name);
        newClass.setGrade(grade);
        return classMapper.updateByClassIdSelective(newClass);
    }



    public Integer insertDepartment(Integer departmentId,String name,String introductions){
        Department department=new Department();
        department.setDepartmentId(departmentId);
        department.setName(name);
        department.setIntroductions(introductions);
        return departmentMapper.insertSelective(department);
    }
    public Integer insertMajor(Integer majorId,Integer departmentId,String name,String introductions){
        Major major=new Major();
        major.setMajorId(majorId);
        major.setDepartmentId(departmentId);
        major.setName(name);
        major.setIntroductions(introductions);
        return majorMapper.insertSelective(major);
    }
}
