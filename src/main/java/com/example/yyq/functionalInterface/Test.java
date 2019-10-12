package com.example.yyq.functionalInterface;

import com.example.yyq.entity.Student;

import java.math.BigDecimal;
import java.util.function.*;

public class Test {
    public static void main(String[] args) {
//      Predicate(用于判断真假) 通过lambda表达式创建
        Predicate<Integer> predicate = x -> x > 185;
        Student student = new Student("9龙", 23, 275);
        System.out.println(
                "9龙的身高高于185吗？：" + predicate.test(student.getStature()));

//      Consumer(用于消费消息，这里用于输出内容到控制台) 通过方法引用创建
        Consumer<String> consumer = System.out::println;
        consumer.accept("命运由我不由天");

//      Function(用于将T映射为R，这里获得student对象的name) 通过方法引用创建
        Function<Student, String> function = Student::getName;
        String name = function.apply(student);
        System.out.println(name);

//      Supplier(用于生产消息，这里返回Integer类型的数据10) 通过lambda表达式创建
        Supplier<Integer> supplier =
                () -> Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get());

//      UnaryOperator(用于一元操作，这里相当于逻辑非!) 通过lambda表达式创建
        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
        Boolean apply2 = unaryOperator.apply(true);
        System.out.println(apply2);


//      BinaryOperator(用于二元操作，这里用于两个数的乘积) 通过lambda表达式创建
        BinaryOperator<Integer> operator = (x, y) -> x * y;
        Integer integer = operator.apply(2, 3);
        System.out.println(integer);
    }
}
