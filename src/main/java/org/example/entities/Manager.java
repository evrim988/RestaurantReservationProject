package org.example.entities;

import java.util.UUID;

public class Manager {

    private String managerId;
    private String name;
    private String surName;

    public Manager(String name, String surName) {
        this.managerId = UUID.randomUUID().toString();
        this.name = name;
        this.surName = surName;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
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

    @Override
    public String toString() {
        return "Manager{" +
                "managerId='" + getManagerId() + '\'' +
                ", name='" + getName() + '\'' +
                ", surName='" + getSurName() + '\'' +
                '}';
    }
}
