package com.test.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String username, password;
    private List<Profile> profileList;

    public Account(String username) {
        this.username = username;
        this.profileList=new ArrayList<>();
    }

    public Account(String username, String password, List<Profile> profileList) {
        this.username = username;
        this.password = password;
        this.profileList = profileList;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void updateProfileList() {
        List<String> listInfor = ReadFile.getListString("data\\User\\"+username+".txt");
        for(String infor:listInfor) {
            String[] strings = infor.split("-");
//            System.out.println(strings[1]);
            this.profileList.add(new Profile(strings[0], new Birthday(strings[1])));
        }
    }

    @Override
    public String toString() {
        return username+"|"+password;
    }
}
