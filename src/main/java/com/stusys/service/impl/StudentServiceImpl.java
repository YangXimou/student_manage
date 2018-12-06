package com.stusys.service.impl;

import com.github.pagehelper.PageHelper;
import com.stusys.dao.ChildCourseMapper;
import com.stusys.dao.StudentCourseMapper;
import com.stusys.dao.StudentMapper;
import com.stusys.dto.StudentDto;
import com.stusys.pojo.ChildCourse;
import com.stusys.pojo.Student;
import com.stusys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2018/12/2.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ChildCourseMapper childCourseMapper;
    @Autowired
    private StudentCourseMapper studentCourseMapper;
    //添加学生时获取返回该新生的学号
    public Integer getNewStudentId(Integer classId){
        Integer newStudentId=studentMapper.getNewestStudentId(classId);
        if(newStudentId==null)
            return Integer.parseInt(classId+"001");
        return newStudentId+1;
    }
    //    根据学号获取学生详细信息
    public StudentDto getDetailByStudentId(Integer studentId){
        StudentDto studentDto=studentMapper.selectDetailByStudentId(studentId);
        return studentDto;
    }
    //    根据学号获取学生基本信息
    //   （包括：学生学号、姓名、性别、院系名称、专业名称、年级、班级名称、联系电话、照片）
    public StudentDto getBasePlusByStudentId(Integer studentId){
        StudentDto studentDto=studentMapper.getBasePlusByStudentId(studentId);
        return studentDto;
    }
    //    修改学生的联系号码、家庭住址
    public Integer updateSelf(Integer studentId,String phone,String address){
        Student student=new Student();
        student.setStudentId(studentId);
        student.setAddress(address);
        student.setPhone(phone);
        return studentMapper.updateByStudentIdSelective(student);
    }
    //    修改学生的密码
    public Integer changePassword(Integer studentId,String newPassword){
        Student student=new Student();
        student.setStudentId(studentId);
        student.setPassword(newPassword);
        return studentMapper.updateByStudentIdSelective(student);
    }

    public List<ChildCourse> getChildCourseByStudentId(Integer studentId, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<ChildCourse> childCourseList=studentCourseMapper.selectChildCourseBase(studentId);
        return childCourseList;
    }
}
