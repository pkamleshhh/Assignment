package com.example.assignment.model;

import com.example.assignment.Register;

public class User extends Register {
    String fullName;
    String date;
    String email;
    String password;
    User(){
    }
    public User(String fullName, String date, String email, String password){
    this.fullName=fullName;
    this.date=date;
    this.email=email;
    this.password=password;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
