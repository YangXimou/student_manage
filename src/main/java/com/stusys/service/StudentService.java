package com.stusys.service;

import com.stusys.dto.StudentDto;
import com.stusys.pojo.ChildCourse;
import com.stusys.pojo.Student;
import com.stusys.vo.ResultVO;

import java.util.List;

/**
 * Created by Simon on 2018/12/2.
 */
public interface StudentService {
    public Integer getNewStudentId(Integer classId);
    public StudentDto getDetailByStudentId(Integer studentId);
    public StudentDto getBasePlusByStudentId(Integer studentId);
    public Integer updateSelf(Integer studentId,String phone,String address);
    public Integer changePassword(Integer studentId,String newPassword);
    public List<ChildCourse> getChildCourseByStudentId(Integer studentId, Integer pageNum, Integer pageSize);
}
