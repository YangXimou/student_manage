package com.stusys.service.impl;

import com.github.pagehelper.PageHelper;
import com.stusys.dao.ChildCourseMapper;
import com.stusys.pojo.ChildCourse;
import com.stusys.service.ChildCourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Simon on 2018/12/3.
 */
public class ChildCourseServiceImpl implements ChildCourseService {
    @Autowired
    private ChildCourseMapper childCourseMapper;
//    public List<ChildCourse> getBaseByStudentId(Integer childCourseId, Integer pageNum, Integer pageSize){
//        PageHelper.startPage(pageNum, pageSize);
//        List<ChildCourse> list = childCourseMapper.selectByChildCourseId(childCourseId);
//    }
}
