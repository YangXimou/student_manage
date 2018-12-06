package com.stusys.controller;

import com.stusys.dto.ClassDto;
import com.stusys.dto.MajorDto;
import com.stusys.pojo.*;
import com.stusys.pojo.Class;
import com.stusys.service.ManagerService;
import com.stusys.util.ResultVOUtil;
import com.stusys.vo.ResultVO;
import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Simon on 2018/12/5.
 */
@RestController
@RequestMapping("/management")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @GetMapping("/getManagerInfoByManagerId")
    public ResultVO getManagerInfo(Integer managerId){
        Manager manager=managerService.getManagerInfo(managerId);
        if(manager!=null)
            return ResultVOUtil.success(manager);
        return ResultVOUtil.error("获取管理员信息失败");
    }



    @GetMapping("/getStudentList")
    public ResultVO getStudentList(Integer pageNum,Integer pageSize){
        List<Student> studentList=managerService.getStudentList(pageNum,pageSize);
        if(studentList!=null)
            return ResultVOUtil.success(studentList);
        return ResultVOUtil.error("获取学生列表失败");
    }
    @GetMapping("/getDepartmentList")
    public ResultVO getDepartmentList(Integer pageNum,Integer pageSize){
        List<Department> departmentList=managerService.getDepartmentList(pageNum,pageSize);
        if(departmentList!=null)
            return ResultVOUtil.success(departmentList);
        return ResultVOUtil.error("获取院系列表失败");
    }
    @GetMapping("/getMajorList")
    public ResultVO getMajorList(Integer pageNum,Integer pageSize){
        List<Major> majorList=managerService.getMajorList(pageNum,pageSize);
        if(majorList!=null)
            return ResultVOUtil.success(majorList);
        return ResultVOUtil.error("获取专业列表失败");
    }
    @GetMapping("/getClassList")
    public ResultVO getClassList(Integer pageNum,Integer pageSize){
        List<ClassDto> classList=managerService.getClassList(pageNum,pageSize);
        if(classList!=null)
            return ResultVOUtil.success(classList);
        return ResultVOUtil.error("获取班级列表失败");
    }
    @GetMapping("/getTeacherList")
    public ResultVO getTeacherList(Integer pageNum,Integer pageSize){
        List<Teacher> teacherList=managerService.getTeacherList(pageNum,pageSize);
        if(teacherList!=null)
            return ResultVOUtil.success(teacherList);
        return ResultVOUtil.error("获取教师列表失败");
    }




    @GetMapping("/searchStudent")
    public ResultVO searchStudent(String key){
        List<Student> studentList=managerService.searchStudent(key);
        if(studentList!=null)
            return ResultVOUtil.success(studentList);
        return ResultVOUtil.error("查询不到指定学生信息");
    }
    @GetMapping("/searchTeacher")
    public ResultVO searchTeacher(String key){
        List<Teacher> teacherList=managerService.searchTeacher(key);
        if(teacherList!=null)
            return ResultVOUtil.success(teacherList);
        return ResultVOUtil.error("查询不到指定教师信息");
    }
    @GetMapping("/getDepartmentInfoByDepartmentId")
    public ResultVO getDepartmentInfoByDepartmentId(Integer departmentId){
        Department department=managerService.getDepartmentInfo(departmentId);
        if(department!=null)
            return ResultVOUtil.success(department);
        return ResultVOUtil.error("获取指定院系信息失败");
    }
    @GetMapping("/getMajorInfoByMajorId")
    public ResultVO getMajorInfoByMajorId(Integer majorId){
        MajorDto majorDto=managerService.getMajorInfo(majorId);
        if(majorDto!=null)
            return ResultVOUtil.success(majorDto);
        return ResultVOUtil.error("获取指定专业信息失败");
    }
    @GetMapping("/getClassInfoByClassId")
    public ResultVO getClassInfoByClassId(Integer classId){
        ClassDto classDto=managerService.getClassInfo(classId);
        if(classDto!=null)
            return ResultVOUtil.success(classDto);
        return ResultVOUtil.error("获取指定班级信息失败");
    }



    @PostMapping("/updateDepartment")
    public ResultVO updateDepartment(Integer departmentId,String name,String introductions){
        Integer result=managerService.updateDepartment(departmentId,name,introductions);
        if(result!=0)
            return ResultVOUtil.success();
        return ResultVOUtil.error("更新院系信息失败");
    }
    @PostMapping("/updateMajor")
    public ResultVO updateMajor(Integer majorId,Integer departmentId,String name,String introductions){
        Integer result=managerService.updateMajor(majorId,departmentId,name,introductions);
        if(result!=0)
            return ResultVOUtil.success();
        return ResultVOUtil.error("更新专业信息失败");
    }
    @PostMapping("/updateClass")
    public ResultVO updateClass(Integer classId,Integer majorId,Integer departmentId,String name,Integer grade){
        Integer result=managerService.updateClass(classId,majorId,departmentId,name,grade);
        if(result!=0)
            return ResultVOUtil.success();
        return ResultVOUtil.error("更新班级信息失败");
    }
    @RequestMapping("/updateStudent")
    public ResultVO updateStudent(HttpServletRequest request) throws ParseException {
        Integer result=managerService.updateStudent(request);
        if(result!=0)
            return ResultVOUtil.success();
        return ResultVOUtil.error("更新学生信息失败");
    }
    @RequestMapping("/updateTeacher")
    public ResultVO updateTeacher(HttpServletRequest request) throws ParseException {
        Integer result=managerService.updateTeacher(request);
        if(result!=0)
            return ResultVOUtil.success();
        return ResultVOUtil.error("更新教师信息失败");
    }



    @PostMapping("/insertDepartment")
    public ResultVO insertDepartment(Integer departmentId,String name,String introductions){
        Integer result=managerService.insertDepartment(departmentId,name,introductions);
        if(result!=0)
            return ResultVOUtil.success();
        return ResultVOUtil.error("添加院系失败");
    }
    @PostMapping("/insertMajor")
    public ResultVO insertMajor(Integer majorId,Integer departmentId,String name,String introductions){
        Integer result=managerService.insertMajor(majorId,departmentId,name,introductions);
        if(result!=0)
            return ResultVOUtil.success();
        return ResultVOUtil.error("添加专业失败");
    }
    @PostMapping("/insertClass")
    public ResultVO insertClass(Integer classId,Integer majorId,Integer departmentId,Integer grade,String name){
        Integer result=managerService.insertClass(classId,majorId,departmentId,grade,name);
        if(result!=0)
            return ResultVOUtil.success();
        return ResultVOUtil.error("添加班级失败");
    }
    @RequestMapping("/insertStudent")
    public ResultVO insertStudent(HttpServletRequest request) throws ParseException {
        Integer result=managerService.insertStudent(request);
        if(result!=0)
            return ResultVOUtil.success();
        return ResultVOUtil.error("添加学生失败");
    }
    @RequestMapping("/insertTeacher")
    public ResultVO insertTeacher(HttpServletRequest request) throws ParseException {
        Integer result=managerService.insertTeacher(request);
        if(result!=0)
            return ResultVOUtil.success();
        return ResultVOUtil.error("添加教师失败");
    }

}
