package com.stusys.controller;

import com.stusys.dao.StudentCourseMapper;
import com.stusys.dto.StudentCourseDetailDto;
import com.stusys.service.StudentCourseService;
import com.stusys.util.ResultVOUtil;
import com.stusys.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Simon on 2018/12/5.
 */
@RestController
@RequestMapping("/studentCourse")
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;
//    根据学号、子课程编号获取该课程的详细信息
//    （包括：
//    课程名称、课程简介、课程学分、上课时间、课程状态、开课学院、
//    平时成绩、期末成绩、最终总成绩、所得学分 课程完成情况
//    教师工号、教师名称）
    @GetMapping("/getCourseInfo")
    public ResultVO getCourseInfo(Integer studentId, Integer childCourseId){
        StudentCourseDetailDto studentCourseDetailDto= studentCourseService.getStudentCourseDetailDto(studentId,childCourseId);
        if(studentCourseDetailDto!=null)
            return ResultVOUtil.success(studentCourseDetailDto);
        return ResultVOUtil.error("根据学号、子课程编号获取该课程的详细信息失败");
    }
    @PostMapping("/updateScore")
    public ResultVO updateScore(Integer studentId, Integer childCourseId,Integer dailyScore,Integer examScore,Integer finalScore,Double credit,Integer state){
        Integer result=studentCourseService.updateScore( studentId,  childCourseId, dailyScore, examScore, finalScore, credit, state);
        if(result!=0)
            return ResultVOUtil.success();
        return ResultVOUtil.error("更新学生课程成绩失败");
    }
}
