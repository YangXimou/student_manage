package com.stusys.dto;

import com.stusys.pojo.Class;

/**
 * Created by Simon on 2018/12/5.
 */
public class ClassDto extends Class {
    private String departmentName;
    private String majorName;

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
}
