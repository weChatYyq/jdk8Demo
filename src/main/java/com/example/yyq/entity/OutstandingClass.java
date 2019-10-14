package com.example.yyq.entity;

import lombok.Data;

import java.util.List;

/**
 * 班级
 */
@Data
public class OutstandingClass {
    String name;
    List<Student> students;

    public OutstandingClass() {
    }

    public OutstandingClass(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }
}
