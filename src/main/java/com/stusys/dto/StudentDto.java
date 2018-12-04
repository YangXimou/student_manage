package com.stusys.dto;

import com.stusys.pojo.Student;

/**
 * Created by Simon on 2018/12/4.
 */
public class StudentDto extends Student {
    private String departmentName;
    private String majorName;
    private String className;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
