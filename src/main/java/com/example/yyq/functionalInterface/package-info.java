/**
 * 函数式接口(包说明类)
 *
 * 定义：
 *   使用@FunctionalInterface注解的接口或者只有一个抽象方法的接口(可以不带@FunctionalInterface注解):
 *
 * 扩展：
 *   1、只能有一个抽象方法的接口
 *   2、因为 {@linkplain com.example.yyq.functionalInterface.Functional01#count()
 *      抽象方法} 有一个实现，所以不是抽象方法。
 *   3、覆盖{@code java.lang.Object}的抽象方法比如{@link com.example.yyq.functionalInterface.Functional01#toString()}，
 *      不能作为函数式接口的抽象方法。因为任何实现该接口的类都可以重新实现对应的方法。
 *
 * 创建：
 *   函数式接口可以通过 lambda expressions(lambda表达式), method references(方法引用), or constructor references(构造函数引用) 创建
 *
 * java8自带的常用函数式接口:
 *   {@linkplain java.util.function.Predicate,java.util.function.Consumer,java.util.function.Function,java.util.function.Supplier}
 *   {@linkplain java.util.function.UnaryOperator,java.util.function.BinaryOperator}
 * 测试demo:{@linkplain com.example.yyq.functionalInterface.Test}
 *
 */
package com.example.yyq.functionalInterface;