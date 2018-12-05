package com.stusys.dto;

/**
 * Created by Simon on 2018/12/5.
 */
public class TeacherBaseDto {
    private Integer teacherId;
    private String teacherName;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
