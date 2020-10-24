package com.example.meetingdemo.pojo;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

//用户实体类
@Table(name = "user")
public class User {
    @Id
    @Column(name = "uId")
    private Integer uId;
    @Column(name = "uName")
    private String uName;
    @Column(name = "uPassword")
    private String uPassword;
    @Column(name = "uRole")
    private String uRole;
    @Column(name = "uPermission")
    private String uPermission;
    @Column(name = "uState")
    private Integer uState;

    public User() {
    }

    public User(Integer uId, String uName, String uPassword, String uRole, String uPermission, Integer uState) {
        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uRole = uRole;
        this.uPermission = uPermission;
        this.uState = uState;
    }

    public Integer getuState() {
        return uState;
    }

    public void setuState(Integer uState) {
        this.uState = uState;
    }

    public String getuRole() {
        return uRole;
    }

    public void setuRole(String uRole) {
        this.uRole = uRole;
    }

    public String getuPermission() {
        return uPermission;
    }

    public void setuPermission(String uPermission) {
        this.uPermission = uPermission;
    }


    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uRole='" + uRole + '\'' +
                ", uPermission='" + uPermission + '\'' +
                ", uState=" + uState +
                '}';
    }
}

