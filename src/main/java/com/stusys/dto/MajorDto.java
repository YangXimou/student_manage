package com.stusys.dto;

import com.stusys.pojo.Major;

/**
 * Created by Simon on 2018/12/5.
 */
public class MajorDto extends Major{
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
