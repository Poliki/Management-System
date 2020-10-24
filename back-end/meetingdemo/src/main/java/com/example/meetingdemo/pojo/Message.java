package com.example.meetingdemo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "message")
public class Message {
    @Id
    @Column(name = "mId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mId;
    @Column(name = "mName")
    private String mName;
    @Column(name = "dId")
    private Integer dId;
    @Column(name = "pId")
    private Integer pId;
    @Column(name = "mDate")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date mDate;
    @Column(name = "mHost")
    private String mHost;
    @Column(name = "mContent")
    private String mContent;
    @Column(name = "uId")
    private Integer uId;
    //忽略字段，使这个属性不会作为数据库中的字段
    @Transient
    private Department department;
    @Transient
    private Place place;


    public Message() {
    }

    public Message(String mName, Integer dId, Integer pId, Date mDate, String mHost, String mContent, Integer uId) {
        this.mName = mName;
        this.dId = dId;
        this.pId = pId;
        this.mDate = mDate;
        this.mHost = mHost;
        this.mContent = mContent;
        this.uId = uId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmHost() {
        return mHost;
    }

    public void setmHost(String mHost) {
        this.mHost = mHost;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Message{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", dId=" + dId +
                ", pId=" + pId +
                ", mDate=" + mDate +
                ", mHost='" + mHost + '\'' +
                ", mContent='" + mContent + '\'' +
                ", uId=" + uId +
                ", department=" + department +
                ", place=" + place +
                '}';
    }
}