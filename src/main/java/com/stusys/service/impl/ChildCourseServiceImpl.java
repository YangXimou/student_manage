package com.stusys.service.impl;

import com.github.pagehelper.PageHelper;
import com.stusys.dao.ChildCourseMapper;
import com.stusys.pojo.ChildCourse;
import com.stusys.pojo.Student;
import com.stusys.service.ChildCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Simon on 2018/12/3.
 */
@Service
public class ChildCourseServiceImpl implements ChildCourseService {
    @Autowired
    private ChildCourseMapper childCourseMapper;


}
