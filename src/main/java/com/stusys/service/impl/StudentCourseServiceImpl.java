package com.stusys.service.impl;

import com.stusys.dao.StudentCourseMapper;
import com.stusys.dto.StudentCourseDetailDto;
import com.stusys.pojo.StudentCourse;
import com.stusys.service.StudentCourseService;
import com.stusys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Simon on 2018/12/3.
 */
@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired
    private StudentCourseMapper studentCourseMapper;
    //    获取该课程基本信息、成绩信息、讲师信息
    public StudentCourseDetailDto getStudentCourseDetailDto(Integer studentId, Integer childCourseId){
        return studentCourseMapper.selectDetailPlus(studentId,childCourseId);
    }
    public Integer updateScore(Integer studentId, Integer childCourseId,Integer dailyScore,Integer examScore,Integer finalScore,Double credit,Integer state){
        StudentCourse studentCourse=new StudentCourse();
        studentCourse.setStudentId(studentId);
        studentCourse.setChildCourseId(childCourseId);
        studentCourse.setDailyScore(dailyScore.longValue());
        studentCourse.setExamScore(examScore.longValue());
        studentCourse.setFinalScore(finalScore.longValue());
        BigDecimal bigCredit = new BigDecimal(credit);
        studentCourse.setCredit(bigCredit);
        studentCourse.setState(state.byteValue());
        return studentCourseMapper.updateSelective(studentCourse);
    }
}
