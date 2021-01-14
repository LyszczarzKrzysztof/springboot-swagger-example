package com.example.springbootswaggerexample;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("model of data of student")
public class Student {

    @ApiModelProperty("unique id of student")
    private int id;
    private String name;
    private String surname;

    public Student() {
    }

    public Student(int id, String name, String surnname) {
        this.id = id;
        this.name = name;
        this.surname = surnname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surnname='" + surname + '\'' +
                '}';
    }
}
