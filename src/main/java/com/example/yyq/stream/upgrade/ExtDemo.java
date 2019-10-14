package com.example.yyq.stream.upgrade;

import com.example.yyq.entity.OutstandingClass;
import com.example.yyq.entity.SpecialityEnum;
import com.example.yyq.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.maxBy;

public class ExtDemo {
    public static void main(String[] args) {
        List<Student> students1 = new ArrayList<>(3);
        students1.add(new Student("路飞", 23, 175));
        students1.add(new Student("红发", 40, 180));
        students1.add(new Student("白胡子", 50, 185));

        OutstandingClass ostClass1 = new OutstandingClass("一班", students1);
        //复制students1，并移除一个学生
        List<Student> students2 = new ArrayList<>(students1);
        students2.remove(1);
        OutstandingClass ostClass2 = new OutstandingClass("二班", students2);
        //将ostClass1、ostClass2转换为Stream
        Stream<OutstandingClass> classStream = Stream.of(ostClass1, ostClass2);
        OutstandingClass outstandingClass = biggestGroup(classStream);
        System.out.println("人数最多的班级是：" + outstandingClass.getName());

        System.out.println("一班平均年龄是：" + averageNumberOfStudent(students1));


//转换成块
//        常用的流操作是将其分解成两个集合，Collectors.partitioningBy帮我们实现了，接收一个Predicate函数式接口。
        //将示例学生分为会唱歌与不会唱歌的两个集合。
        List<Student> students3 = new ArrayList<>(3);
        students3.add(new Student("路飞", 23, 175, Arrays.asList(SpecialityEnum.SING, SpecialityEnum.RUNNING)));
        students3.add(new Student("红发", 40, 180, Arrays.asList(SpecialityEnum.DANCE, SpecialityEnum.SWIMMING)));
        students3.add(new Student("白胡子", 50, 185, Arrays.asList(SpecialityEnum.SING, SpecialityEnum.SWIMMING)));
        Map<Boolean, List<Student>> listMap = students3.stream().collect(
                Collectors.partitioningBy(student -> student.getSpecialities().
                        contains(SpecialityEnum.SING)));
        listMap.forEach((key, val) -> System.out.println(key + "--" + val));

//数据分组
//        数据分组是一种更自然的分割数据操作，与将数据分成 ture 和 false 两部分不同，可以使用任意值对数据分组。
//        Collectors.groupingBy接收一个Function做转换。
//        如图，我们使用groupingBy将根据进行分组为圆形一组，三角形一组，正方形一组。
//
//        例子：根据学生第一个特长进行分组
        //省略List<student> students的初始化
        Map<SpecialityEnum, List<Student>> listMap2 =
                students3.stream().collect(
                        Collectors.groupingBy(student -> student.getSpecialities().get(0)));
        listMap2.forEach((key, val) -> System.out.println(key + "--" + val));
//        Collectors.groupingBy与SQL 中的 group by 操作是一样的。


//        字符串拼接
//        如果将所有学生的名字拼接起来，怎么做呢？通常只能创建一个StringBuilder，
//        循环拼接。使用Stream，使用Collectors.joining()简单容易。
//        joining接收三个参数，第一个是分界符，第二个是前缀符，
//        第三个是结束符。也可以不传入参数Collectors.joining()，这样就是直接拼接。
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        String names = students.stream()
                .map(Student::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(names);
    }

    /**
     * 获取人数最多的班级
     */
    private static OutstandingClass biggestGroup(Stream<OutstandingClass> outstandingClasses) {
        return outstandingClasses.collect(
                maxBy(comparing(ostClass -> ostClass.getStudents().size())))
                .orElseGet(OutstandingClass::new);

    }

    /**
     * 计算平均年龄
     */
    private static double averageNumberOfStudent(List<Student> students) {
        return students.stream().collect(averagingInt(Student::getAge));
    }

}
