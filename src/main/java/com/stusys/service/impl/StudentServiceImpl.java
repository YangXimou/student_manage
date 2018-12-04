package com.stusys.service.impl;

import com.github.pagehelper.PageHelper;
import com.stusys.dao.StudentMapper;
import com.stusys.pojo.Student;
import com.stusys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Simon on 2018/12/2.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public Student justTest(){
        Student student=studentMapper.selectByPrimaryKey(1);
        System.out.println(student);
        PageHelper.startPage(2,3);
        List<Student> studentList=studentMapper.selectAll();
        for (Student stu:studentList
                ) {
            System.out.println(stu);
        }
        return student;
    }
}
