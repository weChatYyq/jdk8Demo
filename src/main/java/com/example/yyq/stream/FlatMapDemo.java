package com.example.yyq.stream;

import com.example.yyq.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 将多个Stream合并为一个Stream。惰性求值
 */
public class FlatMapDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

//      调用Stream.of的静态方法将两个list转换为Stream，再通过flatMap将两个流合并为一个。
        List<Student> studentList = Stream.of(students,
                Stream.of(new Student("艾斯", 25, 183),
                        new Student("雷利", 48, 176)).collect(Collectors.toList()))
                .flatMap(students1 -> students1.stream()).collect(Collectors.toList());
        System.out.println(studentList);
    }
}
