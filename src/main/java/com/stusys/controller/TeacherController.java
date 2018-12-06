package com.stusys.controller;

import com.stusys.pojo.ChildCourse;
import com.stusys.pojo.Student;
import com.stusys.pojo.Teacher;
import com.stusys.service.TeacherService;
import com.stusys.util.ResultVOUtil;
import com.stusys.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;
import java.util.List;

/**
 * Created by Simon on 2018/12/5.
 */

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    //添加新教工时返回其工号
    @RequestMapping("/getNewTeacherId")
    public ResultVO getNewTeacherId(Integer departmentId){
        Integer newTeacherId=teacherService.getNewTeacherId(departmentId);
        if(newTeacherId!=null)
            return ResultVOUtil.success(newTeacherId);
        return ResultVOUtil.error("返回新教工工号失败");
    }
//    学生根据教师id获取教师的基本信息，
//    包括：照片、姓名、职务、联系电话、办公室地址
    @GetMapping("/getTeacherBaseByTeacherId")
    public ResultVO getTeacherBaseByTeacherId(Integer teacherId){
        Teacher teacher= teacherService.getTeacherBase(teacherId);
        if(teacher!=null)
            return ResultVOUtil.success(teacher);
        return ResultVOUtil.error("获取教师基本信息失败");
    }
//    根据教师id获取教师的完整信息
    @GetMapping("/getTeacherInfoByTeacherId")
    public ResultVO getTeacherInfoByTeacherId(Integer teacherId){
        Teacher teacher= teacherService.getTeacherInfo(teacherId);
        if(teacher!=null)
            return ResultVOUtil.success(teacher);
        return ResultVOUtil.error("获取教师完整信息失败");
    }
    @PostMapping("/updateTeacherInfo")
    public ResultVO updateTeacherInfo(Integer teacherId,String phone,String address){
        Integer result=teacherService.updateSelf(teacherId,phone,address);
        if(result!=0){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error("修改教师信息失败");
    }
    @PostMapping("/updatePassword")
    public ResultVO updateTeacherInfo(Integer teacherId,String newPassword){
        Integer result=teacherService.changePassword(teacherId,newPassword);
        if(result!=0){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error("修改教师密码失败");
    }
    @GetMapping("/getChildCourseByTeacherId")
    public ResultVO getChildCourseByTeacherId(Integer teacherId,Integer pageNum,Integer pageSize){
        List<ChildCourse>  childCourseList=teacherService.getChildCourseByTeacherId(teacherId,pageNum,pageSize);
        if(childCourseList!=null){
            return ResultVOUtil.success(childCourseList);
        }
        return ResultVOUtil.error("获取教师排课信息失败");
    }
    @GetMapping("/getStudentsInfoByChildCourseId")
    public ResultVO getStudentsInfoByChildCourseId(Integer childCourseId){
        List<Student> studentList=teacherService.getStudentsInfoByChildCourseId(childCourseId);
        if(studentList!=null){
            return ResultVOUtil.success(studentList);
        }
        return ResultVOUtil.error("获取该课程的学生信息失败");
    }
}
