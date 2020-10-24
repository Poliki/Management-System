package com.example.meetingdemo.pojo;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "place")
public class Place {
    @Id
    @Column(name = "pId")
    private Integer pId;
    @Column(name = "pName")
    private String pName;

    public Place() {
    }

    public Place(Integer pId, String pName) {
        this.pId = pId;
        this.pName = pName;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "Place{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                '}';
    }
}
