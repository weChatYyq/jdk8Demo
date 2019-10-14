package com.example.yyq.stream;

import com.example.yyq.entity.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {
    /**
     * Collectors.toList()
     * 将流转换为list。还有toSet()，toMap()等。及早求值。
     *
     * @return
     */
    static List toList() {
        List<Student> studentList = Stream.of(new Student("路飞", 22, 175),
                new Student("红发", 40, 180),
                new Student("白胡子", 50, 185)).collect(Collectors.toList());
        System.out.println(studentList);
        return studentList;
    }

    public static void main(String[] args) {
        toList();
    }
}
