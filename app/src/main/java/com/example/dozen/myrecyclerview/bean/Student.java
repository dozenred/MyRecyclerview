package com.example.dozen.myrecyclerview.bean;

/**
 * Created by dells on 2017/5/4.
 */

public class Student {
    private String firstName;
    private String lastName;
    private float age;

    public Student() {
    }

    public Student(String firstName, String lastName, float age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getInfo(){
        return firstName + " " + lastName + " " + age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }
}
