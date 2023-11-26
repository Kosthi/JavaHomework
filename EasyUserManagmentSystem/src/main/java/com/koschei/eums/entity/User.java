package com.koschei.eums.entity;

public class User {

    private String name;
    private String password;

    public User(String name_, String password_) {
        name = name_;
        password = password_;
    }

    public String getName() {
        return name;
    }

    public void setName(String name_) {
        name = name_;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password_) {
        password = password_;
    }
}
