package com.stusys.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class ChildCourse {
    private Integer id;

    private Integer childCourseId;

    private Integer courseId;

    private String name;

    private BigDecimal credit;

    private String classTime;

    private Byte state;

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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime == null ? null : classTime.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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
        sb.append(", courseId=").append(courseId);
        sb.append(", name=").append(name);
        sb.append(", credit=").append(credit);
        sb.append(", classTime=").append(classTime);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}