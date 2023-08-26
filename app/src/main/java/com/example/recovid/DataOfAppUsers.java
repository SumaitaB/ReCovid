package com.example.recovid;

public class DataOfAppUsers {


    public String username, password, confirmpass, email, gender, usertype;

    public DataOfAppUsers() {

    }

    public DataOfAppUsers(String username, String password, String confirmpass, String email, String gender, String usertype) {
        this.username = username;
        this.password = password;
        this.confirmpass = confirmpass;
        this.email = email;
        this.gender = gender;
        this.usertype = usertype;
    }
}
