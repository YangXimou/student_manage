package com.stusys.service.impl;

import com.github.pagehelper.PageHelper;
import com.stusys.dao.ChildCourseMapper;
import com.stusys.dao.StudentCourseMapper;
import com.stusys.dao.TeacherCourseMapper;
import com.stusys.dao.TeacherMapper;
import com.stusys.pojo.ChildCourse;
import com.stusys.pojo.Student;
import com.stusys.pojo.Teacher;
import com.stusys.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Simon on 2018/12/3.
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentCourseMapper studentCourseMapper;
    @Autowired
    private TeacherCourseMapper teacherCourseMapper;

    public Integer getNewTeacherId(Integer departmentId){
        String key=departmentId.toString()+Calendar.getInstance().get(Calendar.YEAR);
        Integer newestTeacherId=teacherMapper.getNewestTeacherId(key);
        if(newestTeacherId==null)
            return Integer.parseInt(key+"0001");
        return newestTeacherId+1;
    }

    public Teacher getTeacherBase(Integer teacherId){
        return teacherMapper.getBaseByTeacherId(teacherId);
    }

    public Teacher getTeacherInfo(Integer teacherId){
        return teacherMapper.selectByTeacherId(teacherId);
    }
    public Integer updateSelf(Integer teacherId,String phone,String address){
        Teacher teacher=new Teacher();
        teacher.setTeacherId(teacherId);
        teacher.setPhone(phone);
        teacher.setAddress(address);
        return teacherMapper.updateSelective(teacher);
    }
    public Integer changePassword(Integer teacherId,String newPassword){
        Teacher teacher=new Teacher();
        teacher.setTeacherId(teacherId);
        teacher.setPassword(newPassword);
        return teacherMapper.updateSelective(teacher);
    }
    public List<ChildCourse> getChildCourseByTeacherId(Integer teacherId, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<ChildCourse> childCourseIdList = teacherCourseMapper.selectChildCourseBase(teacherId);
        return childCourseIdList;
    }
    public List<Student> getStudentsInfoByChildCourseId(Integer childCourseId){
        return studentCourseMapper.getStudentsBase(childCourseId);
    }


}
