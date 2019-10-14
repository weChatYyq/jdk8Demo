package com.example.yyq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 学生
 */
@Data
@AllArgsConstructor
public class Student {
    String name;
    Integer age;
    Integer stature;

    List<SpecialityEnum> specialities;

    public Student(String name, Integer age, Integer stature) {
        this.name = name;
        this.age = age;
        this.stature = stature;
    }
}
