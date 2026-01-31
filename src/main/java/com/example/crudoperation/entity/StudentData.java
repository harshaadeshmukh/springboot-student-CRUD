package com.example.crudoperation.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentData {
    @Id

    private int id;

    private String name;


    public StudentData() {
    }


    public StudentData(int id, String name) {
        this.id = id;
        this.name = name;
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
        name = name;
    }
}
