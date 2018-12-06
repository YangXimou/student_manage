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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
    public Integer updateStudent(HttpServletRequest request) throws ParseException {
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        Student student=new Student();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        student.setEnrollmentDate(simpleDateFormat.parse(request.getParameter("enrollmentDate")));
        Integer studentId=Integer.valueOf(request.getParameter("studentId"));
        student.setStudentId(studentId);
        student.setPassword(request.getParameter("password"));
        student.setPhone(request.getParameter("phone"));
        student.setAddress(request.getParameter("address"));
        student.setClassId(Integer.valueOf(request.getParameter("classId")));
        student.setDepartmentId(Integer.valueOf(request.getParameter("departmentId")));
        student.setName(request.getParameter("name"));
        student.setSex(request.getParameter("sex"));
        student.setMajorId(Integer.valueOf(request.getParameter("majorId")));
        student.setGrade(Integer.valueOf(request.getParameter("grade")));
        student.setPoliticalStatus(request.getParameter("politicalStatus"));
        student.setNationality(request.getParameter("nationality"));
        student.setState(Byte.valueOf(request.getParameter("state")));
        //检查form中是否有enctype="multipart/form-data".
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String filename=file.getOriginalFilename();
                    String newFileName=studentId+"userImg."+filename.substring(filename.lastIndexOf(".")+1);
                    String path=request.getSession().getServletContext().getRealPath("/image/")+newFileName;
                    student.setImage("/image/"+newFileName);
                    //上传
                    try {
                        file.transferTo(new File(path));
                        return studentMapper.updateByStudentIdSelective(student);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return 0;
    }
    public Integer updateTeacher(HttpServletRequest request) throws ParseException {
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        Teacher teacher=new Teacher();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        teacher.setEnrollmentDate(simpleDateFormat.parse(request.getParameter("enrollmentDate")));
        Integer teacherId=Integer.valueOf(request.getParameter("teacherId"));
        teacher.setTeacherId(teacherId);
        teacher.setPassword(request.getParameter("password"));
        teacher.setPhone(request.getParameter("phone"));
        teacher.setAddress(request.getParameter("address"));
        teacher.setDepartmentId(Integer.valueOf(request.getParameter("departmentId")));
        teacher.setName(request.getParameter("name"));
        teacher.setSex(request.getParameter("sex"));
        teacher.setIdentity(request.getParameter("identity"));
        teacher.setPoliticalStatus(request.getParameter("politicalStatus"));
        teacher.setNationality(request.getParameter("nationality"));
        teacher.setState(Byte.valueOf(request.getParameter("state")));
        //检查form中是否有enctype="multipart/form-data".
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String filename=file.getOriginalFilename();
                    String newFileName=teacherId+"userImg."+filename.substring(filename.lastIndexOf(".")+1);
                    String path=request.getSession().getServletContext().getRealPath("/image/")+newFileName;
                    teacher.setImage("/image/"+newFileName);
                    //上传
                    try {
                        file.transferTo(new File(path));
                        return teacherMapper.updateSelective(teacher);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return 0;
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
    public Integer insertClass(Integer classId,Integer majorId,Integer departmentId,Integer grade,String name){
        Class newClass=new Class();
        newClass.setClassId(classId);
        newClass.setMajorId(majorId);
        newClass.setDepartmentId(departmentId);
        newClass.setName(name);
        newClass.setGrade(grade);
        return classMapper.insertSelective(newClass);
    }
    public Integer insertStudent(HttpServletRequest request) throws ParseException {
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        Student student=new Student();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        student.setEnrollmentDate(simpleDateFormat.parse(request.getParameter("enrollmentDate")));
        Integer studentId=Integer.valueOf(request.getParameter("studentId"));
        student.setStudentId(studentId);
        student.setPassword(request.getParameter("password"));
        student.setPhone(request.getParameter("phone"));
        student.setAddress(request.getParameter("address"));
        student.setClassId(Integer.valueOf(request.getParameter("classId")));
        student.setDepartmentId(Integer.valueOf(request.getParameter("departmentId")));
        student.setName(request.getParameter("name"));
        student.setSex(request.getParameter("sex"));
        student.setMajorId(Integer.valueOf(request.getParameter("majorId")));
        student.setGrade(Integer.valueOf(request.getParameter("grade")));
        student.setPoliticalStatus(request.getParameter("politicalStatus"));
        student.setNationality(request.getParameter("nationality"));
        student.setState(Byte.valueOf(request.getParameter("state")));
        //检查form中是否有enctype="multipart/form-data".
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String filename=file.getOriginalFilename();
                    String newFileName=studentId+"userImg."+filename.substring(filename.lastIndexOf(".")+1);
                    String path=request.getSession().getServletContext().getRealPath("/image/")+newFileName;
                    student.setImage("/image/"+newFileName);
                    //上传
                    try {
                        file.transferTo(new File(path));
                        return studentMapper.insertSelective(student);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return 0;
    }
    public Integer insertTeacher(HttpServletRequest request) throws ParseException {
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        Teacher teacher=new Teacher();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        teacher.setEnrollmentDate(simpleDateFormat.parse(request.getParameter("enrollmentDate")));
        Integer teacherId=Integer.valueOf(request.getParameter("teacherId"));
        teacher.setTeacherId(teacherId);
        teacher.setPassword(request.getParameter("password"));
        teacher.setPhone(request.getParameter("phone"));
        teacher.setAddress(request.getParameter("address"));
        teacher.setDepartmentId(Integer.valueOf(request.getParameter("departmentId")));
        teacher.setName(request.getParameter("name"));
        teacher.setSex(request.getParameter("sex"));
        teacher.setIdentity(request.getParameter("identity"));
        teacher.setPoliticalStatus(request.getParameter("politicalStatus"));
        teacher.setNationality(request.getParameter("nationality"));
        teacher.setState(Byte.valueOf(request.getParameter("state")));
        //检查form中是否有enctype="multipart/form-data".
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String filename=file.getOriginalFilename();
                    String newFileName=teacherId+"userImg."+filename.substring(filename.lastIndexOf(".")+1);
                    String path=request.getSession().getServletContext().getRealPath("/image/")+newFileName;
                    teacher.setImage("/image/"+newFileName);
                    //上传
                    try {
                        file.transferTo(new File(path));
                        return teacherMapper.insertSelective(teacher);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return 0;
    }
}
