package org.example.entities;

import java.util.UUID;

public class Customer {

    private String customerId;
    private String name;
    private String surName;
    private String phone;
    private String mail;

    public Customer(String name, String surName, String phone, String mail) {
        this.customerId = UUID.randomUUID().toString();
        this.name = name;
        this.surName = surName;
        this.phone = phone;
        this.mail = mail;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + getCustomerId() + '\'' +
                ", name='" + getName() + '\'' +
                ", surName='" + getSurName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", mail='" + getMail() + '\'' +
                '}';
    }
}
