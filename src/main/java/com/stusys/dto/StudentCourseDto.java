package com.stusys.dto;

import java.math.BigDecimal;

/**
 * Created by Simon on 2018/12/4.
 */
public class StudentCourseDto {
    private Integer childCourseId;
    private String name;
    private String classTime;
    private Byte state;

    public Integer getChildCourseId() {
        return childCourseId;
    }

    public void setChildCourseId(Integer childCourseId) {
        this.childCourseId = childCourseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}
