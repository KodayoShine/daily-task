package com.test.yg.day201024;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子数组测试
 * 可以原子性的修改数组
 * AtomicIntegerArray的构造方法,是将原本的数组进行拷贝
 *
 *
 */
public class AtomicArrayTest {

    private static int arr[] = {1, 2};

    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);


    public static void main(String[] args) {
        atomicIntegerArray.compareAndSet(0, 1, 3);

        int firstValue = atomicIntegerArray.get(0);
        System.out.println(firstValue);

        int nextValue = atomicIntegerArray.incrementAndGet(0);
        System.out.println(nextValue);
    }


}
