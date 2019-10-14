package com.example.yyq.stream;

import com.example.yyq.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 转换功能，内部就是Function接口。惰性求值
 */
public class MapDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

//      例子中将student对象转换为String对象，获取student的名字。
        List<String> names = students.stream().map(student -> student.getName())
                .collect(Collectors.toList());
        System.out.println(names);
    }
}
