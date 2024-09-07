package com.example.testapp;

public class UserModel {
    private String username;
    private String email;
    private String pass;
    private String mobile;

    // Constructor
    public UserModel(String username, String email, String pass, String mobile) {
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.mobile = mobile;
    }

    // Getter and Setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
