package com.stusys.dto;

import com.stusys.pojo.StudentCourse;

/**
 * Created by Simon on 2018/12/5.
 */
public class StudentCourseDetailDto extends StudentCourse {
    private ChildCourseDto courseDetail;
    private TeacherBaseDto teacherBase;

    public ChildCourseDto getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(ChildCourseDto courseDetail) {
        this.courseDetail = courseDetail;
    }

    public TeacherBaseDto getTeacherBase() {
        return teacherBase;
    }

    public void setTeacherBase(TeacherBaseDto teacherBase) {
        this.teacherBase = teacherBase;
    }
}
