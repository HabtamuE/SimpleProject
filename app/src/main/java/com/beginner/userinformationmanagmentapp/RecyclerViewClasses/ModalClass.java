package com.beginner.userinformationmanagmentapp.RecyclerViewClasses;

import java.io.Serializable;

public class ModalClass implements Serializable {
    int ID;
    String firstname,lastname,username,password,email,phone,gender;

    public ModalClass(int ID, String firstname, String lastname, String username, String password,String email, String phone, String gender) {
        this.ID = ID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password=password;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }
    public ModalClass(int ID, String firstname, String lastname) {
        this.ID = ID;
        this.firstname = firstname;
        this.lastname = lastname;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
