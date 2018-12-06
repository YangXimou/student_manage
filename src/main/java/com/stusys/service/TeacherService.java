package com.stusys.service;

import com.stusys.pojo.ChildCourse;
import com.stusys.pojo.Student;
import com.stusys.pojo.Teacher;
import com.stusys.vo.ResultVO;

import java.util.List;

/**
 * Created by Simon on 2018/12/3.
 */
public interface TeacherService {
    public Integer getNewTeacherId(Integer departmentId);
    public Teacher getTeacherBase(Integer teacherId);
    public Teacher getTeacherInfo(Integer teacherId);
    public Integer updateSelf(Integer teacherId,String phone,String address);
    public Integer changePassword(Integer teacherId,String newPassword);
    public List<ChildCourse> getChildCourseByTeacherId(Integer teacherId, Integer pageNum, Integer pageSize);
    public List<Student> getStudentsInfoByChildCourseId(Integer childCourseId);

}
