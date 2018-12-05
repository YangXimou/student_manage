package com.stusys.controller;

import com.stusys.dto.StudentDto;
import com.stusys.pojo.ChildCourse;
import com.stusys.service.StudentService;
import com.stusys.util.ResultVOUtil;
import com.stusys.vo.ResultDataVO;
import com.stusys.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Simon on 2018/12/4.
 */

@RestController
@RequestMapping("/student")
public class StudenController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/getStudentInfoByStudentId")
    public ResultVO getStudentInfoByStudentId(Integer studentId){
        StudentDto studentDto=studentService.getDetailByStudentId(studentId);
        if(studentDto!=null){
            return ResultVOUtil.success(studentDto);
        }
        return ResultVOUtil.error("获取学生详细信息失败");
    }
    @GetMapping("/getStudentBaseInfoByStudentId")
    public ResultVO getStudentBaseInfoByStudentId(Integer studentId){
        StudentDto studentDto=studentService.getBasePlusByStudentId(studentId);
        if(studentDto!=null){
            return ResultVOUtil.success(studentDto);
        }
        return ResultVOUtil.error("获取学生基本信息失败");
    }
    @PostMapping("/updateStudentInfo")
    public ResultVO updateStudentInfo(Integer studentId,String phone,String address){
        Integer result=studentService.updateSelf(studentId,phone,address);
        if(result!=0){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error("修改学生信息失败");
    }
    @PostMapping("/updatePassword")
    public ResultVO updatePassword(Integer studentId,String newPassword){
        Integer result=studentService.changePassword(studentId,newPassword);
        if(result!=0){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error("修改密码失败");
    }
    @GetMapping("/getChildCourseByStudentId")
    public ResultVO getChildCourseByStudentId(Integer studentId,Integer pageNum,Integer pageSize){
        List<ChildCourse> childCourseList=studentService.getChildCourseByStudentId(studentId,pageNum,pageSize);
        if(childCourseList!=null){
            return ResultVOUtil.success(childCourseList);
        }
        return ResultVOUtil.error("获取学生上课信息失败");
    }
}
