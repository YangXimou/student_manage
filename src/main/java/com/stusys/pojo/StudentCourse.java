package com.stusys.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class StudentCourse {
    private Integer id;

    private Integer childCourseId;

    private Integer studentId;

    private Long dailyScore;

    private Long examScore;

    private Long finalScore;

    private BigDecimal credit;

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

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Long getDailyScore() {
        return dailyScore;
    }

    public void setDailyScore(Long dailyScore) {
        this.dailyScore = dailyScore;
    }

    public Long getExamScore() {
        return examScore;
    }

    public void setExamScore(Long examScore) {
        this.examScore = examScore;
    }

    public Long getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Long finalScore) {
        this.finalScore = finalScore;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
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
        sb.append(", studentId=").append(studentId);
        sb.append(", dailyScore=").append(dailyScore);
        sb.append(", examScore=").append(examScore);
        sb.append(", finalScore=").append(finalScore);
        sb.append(", credit=").append(credit);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}