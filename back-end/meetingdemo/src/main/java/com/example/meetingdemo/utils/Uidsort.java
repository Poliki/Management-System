package com.example.meetingdemo.utils;

import com.example.meetingdemo.pojo.User;

import java.util.Comparator;

public class Uidsort implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        int uid1 = u1.getuId();
        int uid2 = u2.getuId();
        int n = uid2 - uid1;
        return uid1 - uid2;
    }
}
