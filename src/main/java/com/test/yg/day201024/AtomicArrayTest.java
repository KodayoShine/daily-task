package com.test.yg.day201024;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子数组测试
 * 可以原子性的修改数组
 * AtomicIntegerArray的构造方法,是将原本的数组进行拷贝
 * 这样原本数组的对应索引的值,和新对象的值 不一样
 *
 */
public class AtomicArrayTest {

    private static int arr[] = {1, 2};

    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);


    public static void main(String[] args) {
        atomicIntegerArray.compareAndSet(0, 1, 3);

        int firstValue = atomicIntegerArray.get(0);
        System.out.println(firstValue);
        int originalValue = arr[0];
        System.out.println("比较:" + (firstValue == originalValue));

        int nextValue = atomicIntegerArray.incrementAndGet(0);
        System.out.println(nextValue);
        
        
    }


}
