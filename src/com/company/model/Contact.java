package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String phoneNumber;
    private String groupContact;
    private String name;
    private String gender;
    private String address;
    private String dateOfBirth;
    private String email;

    public Contact() {
    }

    public Contact(String phoneNumber, String groupContact, String name, String gender, String address, String dateOfBirth, String email) {
        this.phoneNumber = phoneNumber;
        this.groupContact = groupContact;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroupContact() {
        return groupContact;
    }

    public void setGroupContact(String groupContact) {
        this.groupContact = groupContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s", getPhoneNumber(), getGroupContact(), getName(), getGender(), getAddress(), getDateOfBirth(), getEmail());
    }
}
