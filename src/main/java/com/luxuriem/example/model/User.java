package com.luxuriem.example.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    private String name;
    private String surname;
    private String email;
    private int age;

    public User() {}

    public User(String name, String surname, String email, int age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
