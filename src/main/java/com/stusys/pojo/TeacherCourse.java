package com.stusys.pojo;

import java.util.Date;

public class TeacherCourse {
    private Integer id;

    private Integer childCourseId;

    private Integer teacherId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChildCourseId() {
        return childCourseId;
    }

    public void setChildCourseId(Integer childCourseId) {
        this.childCourseId = childCourseId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", childCourseId=").append(childCourseId);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}