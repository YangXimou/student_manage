package com.stusys.service;

import com.stusys.dto.StudentCourseDetailDto;

/**
 * Created by Simon on 2018/12/3.
 */
public interface StudentCourseService {
    public StudentCourseDetailDto getStudentCourseDetailDto(Integer studentId, Integer childCourseId);
    public Integer updateScore(Integer studentId, Integer childCourseId,Integer dailyScore,Integer examScore,Integer finalScore,Double credit,Integer state);

}
