package com.example.yyq.functionalInterface;

/**
 * 函数式接口实例
 */
@FunctionalInterface
public interface Functional01 {
//  唯一的一个抽象方法
    String doSomeThing();

    String toString();

    default Integer count() {
        return 1;
    }
}
