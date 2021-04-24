package com.test.yg.lock;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 原子更新引用类型
 * 原子更新字段类都是抽象类，每次使用都时候必须使用静态方法newUpdater创建一个
 * 更新器。原子更新类的字段的必须使用publicvolatile修饰符。
 *
 * 使用AtomicIntegerFieldUpdater类进行原子操作的字段,必须使用volatile进行标志
 *
 *
 */
public class AtomicIntegerFieldUpdaterTest {

    static AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Person.class, "age");

    public static void main(String[] args) {
        Person person = new Person(18, "shine");
        atomicIntegerFieldUpdater.getAndIncrement(person);
        System.out.println(person.age);
    }

}

class Person {
    volatile int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
